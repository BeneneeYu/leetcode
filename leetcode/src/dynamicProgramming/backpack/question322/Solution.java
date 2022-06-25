package dynamicProgramming.backpack.question322;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * @author: Shen Zhengyu
 * @create: 2022-06-22 10:49
 **/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1]; // dp[i] represents minimum number of coins that can amount to i
        Arrays.fill(dp, max); // impossible case makes the return value -1
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i){ // or it can not make up amount
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1); // come from choose different coin as the last coin
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }
}
