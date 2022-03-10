package multiplePointer.array.question283;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-10 09:29
 **/
public class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        int headOfAwaiting = 0;
        int n = nums.length;
        while (headOfAwaiting < n) {
            if (nums[headOfAwaiting] != 0) {
                swap(nums, lastNonZero, headOfAwaiting);
                lastNonZero += 1;
            }
            headOfAwaiting += 1;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
