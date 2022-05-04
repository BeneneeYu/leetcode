package daily.question1679;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description: You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 * @author: Shen Zhengyu
 * @create: 2022-05-04 10:09
 **/
public class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left < right){
            int tmp = nums[left] + nums[right];
            if (tmp > k){
                right--;
            }else if (tmp < k){
                left++;
            }else{
                res += 1;
                right--;
                left++;
            }
        }
        return res;
    }

    public int maxOperations2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int requiredNum = k - num;
            if (map.containsKey(requiredNum) && map.get(requiredNum) >= 1){
                res += 1;
                map.put(requiredNum, map.get(requiredNum) - 1);
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}
