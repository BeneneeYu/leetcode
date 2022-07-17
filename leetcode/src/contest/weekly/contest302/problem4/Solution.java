package contest.weekly.contest302.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-17 11:35
 **/
public class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        Arrays.sort(numsDivide);
        a:
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num % nums[j] == 0) continue a;
            }
            for (int j : numsDivide) {
                if (j % num != 0) {
                    continue a;
                }
            }
            return i;
        }
        return -1;
    }
}
