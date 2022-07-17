package contest.weekly.contest302.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-17 10:30
 **/
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] occur = new int[101];
        int res1 = 0;
        int res2 = nums.length;
        for (int num : nums) {
            if (occur[num] == 0) {
                occur[num] += 1;
            } else {
                occur[num] = 0;
                res1 += 1;
                res2 -= 2;
            }
        }
        return new int[]{res1, res2};
    }
}
