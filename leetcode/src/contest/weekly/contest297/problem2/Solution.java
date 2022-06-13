package contest.weekly.contest297.problem2;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-12 10:25
 **/
public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        if (grid.length == 1) return getMinInRow(grid[0]);
        int columns = grid[0].length;
        int rows = grid.length;
        int[][] originalGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            originalGrid[i] = grid[i].clone();
        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns; j++) {
                int cell = originalGrid[i][j];
                int[] cellMoveCost = moveCost[cell];
                for (int k = 0; k < columns; k++) {
                    if (j == 0) {
                        grid[i + 1][k] = grid[i][j] + originalGrid[i + 1][k] + cellMoveCost[k];
                    } else {
                        grid[i + 1][k] = Math.min(grid[i + 1][k], grid[i][j] + originalGrid[i + 1][k] + cellMoveCost[k]);

                    }
                }
            }
        }
        return getMinInRow(grid[rows - 1]);
    }

    private int getMinInRow(int[] row) {
        int minValue = Integer.MAX_VALUE;
        for (int i : row) {
            minValue = Math.min(i, minValue);
        }
        return minValue;
    }
}
