package dynamicProgramming.math.question1359;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-06 09:58
 **/
public class Solution {
    public int countOrders(int n) {
        if (n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[1] = 1L;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] * i * (2 * i - 1);
            dp[i] %= 1000000007L;
        }
        return (int)dp[n];
    }
}
