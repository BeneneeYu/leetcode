package binarySearch.simpleBinarySearch.question34;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-28 14:28
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int l = 0;
        int r = n - 1;
        // find the first number that bigger or equals to target
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[r] != target) return new int[]{-1, -1};
        int ans1 = r;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans2 = r;
        return new int[]{ans1, ans2};
    }
}
