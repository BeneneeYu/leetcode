package dynamicProgramming.array.question91;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-18 12:42
 **/
public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i - 1);
            if (c != '0') dp[i] += dp[i - 1];
            if (i >= 2) {
                int ten = s.charAt(i - 2) - '0';
                if (ten == 1 || (ten == 2 && (c >= '0' && c <= '6'))) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }
}
