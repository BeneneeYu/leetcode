package bfs.matrix.question695;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-15 10:24
 **/
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!isValid(grid, i, j) || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int area = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            area += dfs(grid, newI, newJ);
        }
        return area;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
