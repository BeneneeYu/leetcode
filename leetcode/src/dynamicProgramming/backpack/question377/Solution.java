package dynamicProgramming.backpack.question377;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * <p> Note that different sequences are counted as different combinations.
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * @author: Shen Zhengyu
 * @create: 2022-06-24 13:50
 **/
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1]; // dp[j] the solution number of sum j
        dp[0] = 1;
        for (int i = 1; i <= target; i++) { // consider the solution number of every target
            for (int num : nums) { // end with different numbers
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
