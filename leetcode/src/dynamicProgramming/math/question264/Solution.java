package dynamicProgramming.math.question264;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 * @author: Shen Zhengyu
 * @create: 2022-06-30 15:48
 **/
public class Solution {
    public int nthUglyNumber(int n) {
        // Define three pointers, indicating that the next ugly number is the ugly number pointed to by the current pointer multiplied by the corresponding prime factor
        int[] pos = {0, 0, 0}; // 2,3,5
        int[] multiplier = {2, 3, 5};
        int[] dp = new int[n];
        int[] tmp = new int[3];
        dp[0] = 1;
        int completePos = 1;
        while (completePos < n) {
            int nextUgly = Integer.MAX_VALUE;
            for (int j = 0; j < multiplier.length; j++) {
                int nextUglyCandidate = multiplier[j] * dp[pos[j]];
                tmp[j] = nextUglyCandidate;
                nextUgly = Math.min(nextUgly, nextUglyCandidate);
            }
            for (int j = 0; j < multiplier.length; j++) {
                if (tmp[j] == nextUgly) {
                    pos[j] += 1;
                }
            }
            dp[completePos++] = nextUgly;
        }
        return dp[n - 1];
    }
}
