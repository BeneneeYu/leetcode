package dynamicProgramming.array.question740;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-05 10:37
 **/
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int num : nums) {
            dp[num] += num;
        }
        return rob(dp);
    }

    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
