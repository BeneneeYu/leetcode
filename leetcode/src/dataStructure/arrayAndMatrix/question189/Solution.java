package dataStructure.arrayAndMatrix.question189;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-30 08:56
 **/
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; ++i) {
            tmp[(i + k) % len] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, len);
    }

    public void rotateInArray(int[] nums, int k) {
        k %= nums.length;
        reverseList(nums, 0, nums.length - 1);
        reverseList(nums, 0, k - 1);
        reverseList(nums, k, nums.length - 1);
    }

    public void reverseList(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}