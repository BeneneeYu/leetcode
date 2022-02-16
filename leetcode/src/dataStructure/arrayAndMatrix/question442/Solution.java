package dataStructure.arrayAndMatrix.question442;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * @author: Shen Zhengyu
 * @create: 2022-02-16 12:12
 **/
public class Solution {
    // notice the constraints! n == nums.length, 1 <= nums[i] <= n, Each element in nums appears once or twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len < 1) return result;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0){
                result.add(index + 1);
            }else{
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
