package dynamicProgramming.greedy.question300;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * @author: Shen Zhengyu
 * @create: 2022-07-01 21:34
 **/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1]; // d[i]: for a subsequence of length i, the smallest tail number
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public int lengthOfLISDP(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]: tailed with nums[i], the max length of strictly increasing subsequence
        int len = nums.length;
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
