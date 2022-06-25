package dynamicProgramming.backpack.question518;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * Note that different sequences are not counted as different combinations.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * @author: Shen Zhengyu
 * @create: 2022-06-24 13:29
 **/
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[j]: the combinations number of total amount j
        dp[0] = 1; // select no coins
        for (int coin : coins) { // for every denomination
            for (int i = coin; i <= amount; i++) { // inherit the combinations number
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
