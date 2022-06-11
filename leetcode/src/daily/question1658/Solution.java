package daily.question1658;

/**
 * @program: Leetcode
 * @description: You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 * @author: Shen Zhengyu
 * @create: 2022-06-11 09:57
 **/
public class Solution {
    // This problem is to find the longest subarray of which sum is sum(nums) - x
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = sum - x; // the sum of the subarray we want
        if (count < 0) return -1;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int preSum = 0;
        int maxLength = -1;
        while (right < n) {
            // subtract
            preSum += nums[right];
            while (preSum > count) {
                preSum -= nums[left++];
            }
            if (preSum == count) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right += 1;
        }
        if (maxLength == -1) return -1;
        return n - maxLength;
    }
}
