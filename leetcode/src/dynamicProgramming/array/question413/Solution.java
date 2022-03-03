package dynamicProgramming.array.question413;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-03 08:21
 **/
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len <= 2) return 0;
        // according with previous difference?
        int prevD = nums[1] - nums[0];
        int res = 0;
        // The increment for an added number
        int addTimes = 0;
        for (int i = 2; i < nums.length; i++) {
            // Construct more arithmetic slices
            if (nums[i] - nums[i - 1] == prevD) {
                addTimes += 1;
                res += addTimes;
            } else {
                addTimes = 0;
                prevD = nums[i] - nums[i - 1];
            }
        }
        return res;
    }
}
