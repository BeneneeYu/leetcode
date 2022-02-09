package dataStructure.hash.question532;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-09 08:50
 **/
public class Solution {
    HashSet<Integer> diff;
    HashSet<Integer> detected;

    public int findPairs(int[] nums, int k) {
        // to save the less one in a pair
        diff = new HashSet<>();
        detected = new HashSet<>();
        for (int num : nums) {
            // num may be the bigger one in a pair
            if (detected.contains(num - k)) {
                diff.add(num - k);
            }
            // may be the smaller one
            if (detected.contains(num + k)) {
                diff.add(num);
            }
            detected.add(num);
        }
        return diff.size();
    }
}
