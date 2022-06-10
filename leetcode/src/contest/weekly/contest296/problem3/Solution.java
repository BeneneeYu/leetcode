package contest.weekly.contest296.problem3;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-05 10:26
 **/
public class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pos.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int toBeChanged = operation[0];
            int changeTo = operation[1];
            int originalPos = pos.get(toBeChanged);
            nums[originalPos] = changeTo;
            pos.put(changeTo, originalPos);
            pos.remove(toBeChanged);
        }
        return nums;
    }
}
