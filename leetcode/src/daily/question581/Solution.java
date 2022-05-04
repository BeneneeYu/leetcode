package daily.question581;

/**
 * @program: Leetcode
 * @description: Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 * @author: Shen Zhengyu
 * @create: 2022-05-03 13:24
 **/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length <= 1) return 0;
        int high = 0;
        int low = length - 1;
        int max = nums[0];
        int min = nums[length - 1];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - i - 1]);
            if (max > nums[i]) high = i;
            if (min < nums[length - i - 1]) low = length - i - 1;
        }
        return high > low ? high - low + 1:0;
    }
}

