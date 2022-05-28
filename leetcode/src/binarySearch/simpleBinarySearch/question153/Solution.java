package binarySearch.simpleBinarySearch.question153;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-28 16:20
 **/
public class Solution {
    public int findMin(int[] nums) {
        // todo: find the first element that smaller than its previous element
        // the min value should always be in the range
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[0];
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[r] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }

    public int findMin2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[left] < nums[right]) return nums[0];
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                right = mid; // must include the min value
            } else if (nums[mid] > nums[right]) {
                left = mid + 1; // left closed right open
                // if nums[mid] is min value, the program enters the first branch
            }
        }
        return nums[left];
    }
}
