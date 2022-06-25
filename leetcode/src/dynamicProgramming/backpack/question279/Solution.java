package dynamicProgramming.backpack.question279;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * 1 <= n <= 10^4
 * @author: Shen Zhengyu
 * @create: 2022-06-24 13:15
 **/
public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int floor = (int) Math.sqrt(n) + 1;
        int[] perfectSquares = new int[floor + 1];
        for (int i = 1; i <= floor; i++) {
            perfectSquares[i] = i * i;
        }
        int[] dp = new int[n + 1]; // dp[j]: min number of ps to sum up j
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= floor; j++) {
                if (perfectSquares[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i - perfectSquares[j]] + 1);
            }
        }
        return dp[n];
    }
}
