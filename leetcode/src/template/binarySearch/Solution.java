package template.binarySearch;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-17 19:42
 **/
public class Solution {
    //[left, right]
    public int binarySearchOne(int[] nums, int target) {
        // handle corner case
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        //[start, end]
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    //[left, right)
    public int binarySearchTwo(int[] nums, int target) {
        // handle corner case
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length;

        // [start, end)
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }
}
