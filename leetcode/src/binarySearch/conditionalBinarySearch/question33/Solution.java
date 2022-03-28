package binarySearch.conditionalBinarySearch.question33;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-28 09:14
 **/
public class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
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
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

    }
}
