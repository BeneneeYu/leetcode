package dataStructure.hash.question287;

/**
 * @program: Leetcode
 * @description: Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * @author: Shen Zhengyu
 * @create: 2022-03-29 10:21
 **/
public class Solution {

    // O(n), O(1), modified
    public int findDuplicate(int[] nums) {
        // according to the constraint, we can use the array as a hashmap
        while (nums[0] != nums[nums[0]]) {
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }

    
}
