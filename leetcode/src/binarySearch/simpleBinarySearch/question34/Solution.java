package binarySearch.simpleBinarySearch.question34;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-28 14:28
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target);
        int r = binarySearch(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{l, r - 1};
        }
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return l;
    }
}
