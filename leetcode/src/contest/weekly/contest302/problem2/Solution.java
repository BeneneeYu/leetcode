package contest.weekly.contest302.problem2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-17 10:30
 **/
public class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int[] digitSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            while (tmp > 0){
                digitSum[i] += tmp % 10;
                tmp /= 10;
            }
        }
        int max = -1;
        HashSet<Integer> examined = new HashSet<>();
        for(int i = nums.length - 1; i >= 1; i--){
            int sameDigit = digitSum[i];
            if (examined.contains(sameDigit)) continue;
            for(int j = i - 1; j >=0;j--){
                if (digitSum[j] == sameDigit){
                    max = Math.max(max, nums[i] + nums[j]);
                    examined.add(sameDigit);
                }
            }
        }
        return max;
    }
}
