package dynamicProgramming.array.question120;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-03 22:36
 **/
public class Solution {
    // top-down
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int top = triangle.get(0).get(0);
        if (rows == 1) return top;
        int cols = triangle.get(rows - 1).size();
        int[][] dp = new int[rows][cols]; // the minimum sum of which the end point is triangle.get(row).get(col);
        dp[0][0] = top;
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col <= row; col++) {
                // the way the upper layer affects the next layer
                if (col == 0 || col == row) {
                    dp[row][col] = dp[row - 1][col == 0 ? 0 : col - 1] + triangle.get(row).get(col);
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + triangle.get(row).get(col);
                }
            }
        }
        int[] bottomRowSum = dp[rows - 1];
        int minSum = Integer.MAX_VALUE;
        for (Integer integer : bottomRowSum) {
            minSum = Math.min(integer, minSum);
        }
        return minSum;
    }
}
