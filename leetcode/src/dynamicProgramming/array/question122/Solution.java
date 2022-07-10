package dynamicProgramming.array.question122;

/**
 * @program: Leetcode
 * @description: You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * @author: Shen Zhengyu
 * @create: 2022-07-08 17:48
 **/
public class Solution {
    public int maxProfitDP(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2]; // dp[i][0]: max profit day i not holding stock, dp[i][1]: holding
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // no Multiday transaction
            // not holding
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // not hold and not buy, hold but sell
            // holding
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // hold and not sell, or not hold but buy
        }
        return dp[days - 1][0];
    }

    public int maxProfitGreedy(int[] prices) {
        int profit = 0;
        // action on the day before is decided by the price on the next day
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
