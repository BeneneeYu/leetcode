package dynamicProgramming.doubleSequences.question10;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-30 21:07
 **/
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j]: if s[0,i] and p[0,j] can match
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // if true, 'x*' matches nothing is ok
                    if (matches(s, p, i, j - 1)) { //s[i] is matched, depends on previous
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // depends on previous state
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    // if s[i] can match p[j]
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // '.' can match any character
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
