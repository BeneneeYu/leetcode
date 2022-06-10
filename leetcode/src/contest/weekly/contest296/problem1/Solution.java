package contest.weekly.contest296.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-05 10:26
 **/
public class Solution {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int newLen = nums.length / 2;
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < newLen; i++) {
            if (i % 2 == 0){
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }else{
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }
}
