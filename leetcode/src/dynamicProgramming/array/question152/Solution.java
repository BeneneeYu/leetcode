package dynamicProgramming.array.question152;

/**
 * @program: Leetcode
 * @description: Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *  * The test cases are generated so that the answer will fit in a 32-bit integer.
 *  * A subarray is a contiguous subsequence of the array.
 * @author: Shen Zhengyu
 * @create: 2022-06-29 09:02
 **/
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums, 0, maxF, 0, len);
        System.arraycopy(nums, 0, minF, 0, len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(minF[i - 1] * nums[i], nums[i]));
        }
        int ans = Integer.MIN_VALUE;
        for (int i : maxF) {
            ans = Math.max(i, ans);
        }
        return ans;
    }
}
