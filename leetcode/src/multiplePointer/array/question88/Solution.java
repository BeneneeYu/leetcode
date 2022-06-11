package multiplePointer.array.question88;

/**
 * @program: Leetcode
 * @description: You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * @author: Shen Zhengyu
 * @create: 2022-06-11 20:22
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int resPtr = m + n - 1;
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        // from back to front
        while (ptr1 >= 0 || ptr2 >= 0) {
            if (ptr1 == -1) {
                nums1[resPtr--] = nums2[ptr2--];
            } else if (ptr2 == -1) {
                nums1[resPtr--] = nums1[ptr1--];
            } else {
                if (nums2[ptr2] >= nums1[ptr1]) {
                    nums1[resPtr--] = nums2[ptr2--];
                } else {
                    nums1[resPtr--] = nums1[ptr1--];
                }
            }
        }
    }
}
