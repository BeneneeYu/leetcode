package contest.weekly.contest300.problem4;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-03 11:30
 **/
public class Solution {
    int[][] dp;
    int sum;
    int l;
    int[][] grid;

    public int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        this.grid = grid;
        dp = new int[rows][cols];
        sum = 0;
        l = (int) Math.pow(10, 9) + 7;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                sum = (sum % l + collect(m, n, rows, cols, -1) % l) % l;
            }
        }
        return sum;
    }

    private int collect(int i, int j, int rows, int cols, int prev) {
        if (!validPos(i, j, rows, cols)) return 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int toAdd = 0;
        if (grid[i][j] <= prev) return 0; // will not form strictly increasing sequence
        if (dp[i][j] != 0) return dp[i][j];
        for (int[] direction : directions) {
            int newI = direction[0] + i;
            int newJ = direction[1] + j;
            toAdd += collect(newI, newJ, rows, cols, grid[i][j]);
        }
        dp[i][j] = (1 + toAdd) % l;
        return dp[i][j];
    }

    private boolean validPos(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows & j >= 0 & j < cols;
    }
}
