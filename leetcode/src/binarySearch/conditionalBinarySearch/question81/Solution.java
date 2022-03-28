package binarySearch.conditionalBinarySearch.question81;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-28 09:13
 **/
public class Solution {
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[start] == nums[start + 1]) {
                start += 1;
            }
            while (start < end && nums[end] == nums[end - 1]) {
                end -= 1;
            }
            int mid = (start + end) / 2;
            //[3,1,2,3,3,3,3]，[3,1,2,3,3,3,4]
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] <= nums[mid]) { // the first half is sorted
                if (nums[start] <= target && target <= nums[mid]) { // the range of the first half is [nums[start], nums[mid]]
                    end = mid - 1;
                } else { // then the target appears in the second half, or does not exist
                    start = mid + 1;
                }
            } else { // the second half is sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1
        }, 2));
    }
}
