package dynamicProgramming.backpack.question494;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-20 22:12
 **/
public class Solution {
    int target;
    int[] nums;
    int len;
    int res;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        this.len = nums.length;
        this.res = 0;
        backtrack(0, 0);
        return res;
    }

    private void backtrack(int pointer, int preSum) {
        if (pointer == len - 1) {
            if (preSum + nums[len - 1] == target) {
                res += 1;
            }
            if (preSum - nums[len - 1] == target) {
                res += 1;
            }
            return;
        }
        backtrack(pointer + 1, preSum + nums[pointer]);
        backtrack(pointer + 1, preSum - nums[pointer]);
    }

    public int findTargetSumWaysDP(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) < 0 || (sum - target) % 2 == 1) return 0;
        int n = nums.length;
        int neg = (sum - target) / 2;
        int[][] dp = new int[n + 1][neg + 1]; // number of means to add up neg within the first n elements
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j]; // whatever num is, not choosing it
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public int findTargetSumWaysDPOptimized(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) < 0 || (sum - target) % 2 == 1) return 0;
        int n = nums.length;
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1]; // number of means to add up neg within the first n elements
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
            // no need to update the left part
        }
        return dp[neg];
    }
}
