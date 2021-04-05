package array.question88;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description:给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * @author: Shen Zhengyu
 * @create: 2021-04-05 15:29
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tmp[] = new int[nums1.length];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        if (n == 0){
            return;
        }
        while (p3 < nums1.length){
            while (p1 < m && ( p2 == n || nums1[p1] <= nums2[p2])){
                tmp[p3] = nums1[p1];
                p1++;
                p3++;
            }
            while (p2 < n && (p1 == m || nums2[p2] <= nums1[p1])){
                tmp[p3] = nums2[p2];
                p2++;
                p3++;
            }
        }

        System.arraycopy(tmp,0,nums1,0,tmp.length);
    }
    public void tailMerge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p3 >= 0){
            while (p1 >= 0 && (p2 == -1 || nums1[p1] >= nums2[p2])){
                nums1[p3] = nums1[p1];
                p3--;
                p1--;
            }
            while (p2 >= 0 && (p1 == -1 || nums2[p2] >= nums1[p1])){
                nums1[p3] = nums2[p2];
                p3--;
                p2--;
            }
        }
    }

        public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        Solution s = new Solution();
        s.merge(nums1,1,nums2,1);
            System.out.println(Arrays.toString(nums1));
            s.tailMerge(nums1,1,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
