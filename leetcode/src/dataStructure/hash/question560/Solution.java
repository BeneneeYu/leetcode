package dataStructure.hash.question560;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * @author: Shen Zhengyu
 * @create: 2022-02-10 12:05
 **/
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // pre-sum and times
        map.put(0,1); // every single element can be a subarray
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)){
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
//        for (Integer integer : map.keySet()) {
//            System.out.println(integer + " " + map.get(integer));
//
//        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testCase = new int[]{1,2,3};
        System.out.println(s.subarraySum(testCase,3));
    }
}
