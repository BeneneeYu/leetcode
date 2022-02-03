package dataStructure.hash.question454;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-03 12:54
 **/
public class Solution {
    // divide and conquer
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int cntResult = 0;
        for (int i : nums1) {
            for (int i1 : nums2) {
                int sum = i + i1;
                int cnt = frequencyMap.getOrDefault(sum, 0);
                frequencyMap.put(sum, cnt + 1);
            }
        }
        for (int i : nums3) {
            for (int i1 : nums4) {
                int sum = i + i1;
                cntResult += frequencyMap.getOrDefault(-sum, 0);
            }
        }
        return cntResult;

    }
}
