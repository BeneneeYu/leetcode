package dynamicProgramming.matrix.question63;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * <p>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * @author: Shen Zhengyu
 * @create: 2022-06-28 18:03
 **/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        // can only move either down or right
        int[][] dp = new int[rows + 1][cols + 1]; // dp[i][j]: ways to reach grid[i-1][j-1]
        for (int i = 0; i <= rows; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= cols; j++) {
            dp[0][j] = 0;
        }
        // initialization complete
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i * j == 1) {
                    dp[1][1] = 1 - obstacleGrid[0][0];
                    continue;
                }
                // depend on the left neighbor grid and neighbor grid on the top
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[rows][cols];
    }

    // only depend on left side and last row, optimize to one-dimension problem
    public int uniquePathsWithObstaclesOptimized(int[][] obstacleGrid) {
        int cols = obstacleGrid[0].length;
        // can only move either down or right
        int[] dp = new int[cols]; // dp[i][j]: ways to reach grid[i-1][j-1]
        dp[0] = 1 - obstacleGrid[0][0];
        // initialization complete
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < cols; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[cols - 1];
    }
}
