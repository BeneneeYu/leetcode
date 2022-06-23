package dynamicProgramming.backpack.question1049;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-22 21:40
 **/
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int stoneWeight : stones) {
            for (int j = target; j >= stoneWeight; j--) {
                if (dp[j - stoneWeight]) {
                    dp[j] = true;
                }
                // dp[j] = dp[j] || dp[j - stoneWeight];
            }
        }
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
