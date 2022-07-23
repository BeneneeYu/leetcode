package dynamicProgramming.sections.question516;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-20 19:32
 **/
public class Solution {
    public int longestPalindromeSubseq1(String s) {
        String reversedS = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1]; // dp[m][n]: the longest common substring between s1[0,m] and s2[0,n]
        int max = 0;
        for (int i = 1; i <= len; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= len; j++) {
                char c2 = reversedS.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[][] dp = new int[len][len]; // dp[m][n]: the longest palindrome in s[m,n]
        for (int i = len - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
