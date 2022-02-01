package dynamicProgramming.array.question121;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-01 09:32
 **/
public class Solution {
    // limits: profit is based on days behind any higher stock price
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1, cheapest = prices[0]; i < prices.length; i++) {
            if (prices[i] >= cheapest) {
                maxProfit = Math.max(maxProfit, prices[i] - cheapest);
            }
            cheapest = Math.min(cheapest, prices[i]);
        }
        return maxProfit;
    }
}
