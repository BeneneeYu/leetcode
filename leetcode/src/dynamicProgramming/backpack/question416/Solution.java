package dynamicProgramming.backpack.question416;

/**
 * @program: Leetcode
 * @description: Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * @author: Shen Zhengyu
 * @create: 2022-06-22 19:14
 **/
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        if (len < 2) return false;
        // num > 0
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 == 1 || max > sum / 2) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len + 1][target + 1]; // can add up to target in the first n elements
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < target; j++) { // the previous row
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    // can choose element j or not
                    if (j + num <= target) {
                        dp[i][j + num] = true;
                    }
                }
            }
        }
        for (int i = 0; i <= len; i++) {
            if (dp[i][target]) return true;
        }
        return false;
    }

    public boolean canPartitionOptimized(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        if (len < 2) return false;
        // num > 0
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 == 1 || max > sum / 2) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1]; // can add up to target in the first n elements
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                if (j - num >= 0 && dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }
}
