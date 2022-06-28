package dataStructure.hash.question128;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * @author: Shen Zhengyu
 * @create: 2022-02-16 15:38
 **/
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLength = 0;
        for (int num : numSet) {
            // avoid duplicated calculation
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }
                maxLength = Math.max(maxLength, curStreak);
            }
        }
        return maxLength;
    }
}
