package contest.weekly.contest300.problem3;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-03 10:17
 **/
public class Solution {
    /*
    On day 1, one person discovers a secret.

     You are given an integer delay, which means that each person will share the secret with a new person every day,
     starting from delay days after discovering the secret.
     You are also given an integer forget, which means that each person will forget the secret forget days after discovering it.
     A person cannot share the secret on the same day they forgot it, or on any day afterwards.
     */
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1]; // dp[i]: num of people who started to know the secret on day i
        long l = (int) Math.pow(10, 9) + 7, share = 0, res = 0; // share: the people who are sharing secret know
        dp[1] = 1;
        // on day i, dp[i-delay] people start to share, share += dp[i-delay]
        // dp[i-forget] people forget, share -= dp[i-forget]
        // dp[i] = share
        for (int i = 2; i <= n; i++) {
            share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + l) % l;
            dp[i] = share;
        }
        for (int i = n; i > n - forget; i--) {
            res = (res + dp[i]) % l;
        }
        return (int) res;
    }
}
