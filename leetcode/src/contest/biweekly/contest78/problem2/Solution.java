package contest.biweekly.contest78.problem2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-14 22:30
 **/
public class Solution {
    public int waysToSplitArray(int[] nums) {
        long leftSum = 0;
        long rightSum = 0;
        int res = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum && i < nums.length - 1){
                res += 1;
            }
        }
        return res;
    }
}
