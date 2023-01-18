package daily.question926;

/**
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 * <p>
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * <p>
 * Return the minimum number of flips to make s monotone increasing.
 */
public class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        // dp[i][0]: for the first i chars, the minFlipsMonoIncr with 0 as the last char
        // dp[i][0]: for the first i chars, the minFlipsMonoIncr with 1 as the last char
        int[][] dp = new int[len][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            // increasing, so before 0 is 0, before 1 is 0 or 1
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}
