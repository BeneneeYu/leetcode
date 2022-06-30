package dynamicProgramming.matrix.question221;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * @author: Shen Zhengyu
 * @create: 2022-06-28 20:16
 **/
public class Solution {
    // dp[i][j]: the maximum side length of square whose right-bottom corner is (i-1, j-1)
    // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
    // fix dp[i][j] and consider all the three other squares
    // and fix the min value of three squares and consider dp[i][j]
    // when it comes to number of small squares, it is the sum of dp[i][j]
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
