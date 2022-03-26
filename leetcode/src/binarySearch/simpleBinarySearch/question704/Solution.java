package binarySearch.simpleBinarySearch.question704;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-26 10:11
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
