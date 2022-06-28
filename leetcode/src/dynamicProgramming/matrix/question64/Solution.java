package dynamicProgramming.matrix.question64;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * @author: Shen Zhengyu
 * @create: 2022-06-28 18:27
 **/
public class Solution {
    public int minPathSum(int[][] grid) {
        int cols = grid[0].length;
        // only depends on left side and top, we can reduce the dimension
        int[] dp = new int[cols];
        // at first, path can not from top
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] rows : grid) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dp[j] += rows[0];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + rows[j];
                }
            }
        }
        return dp[cols - 1];
    }
}
