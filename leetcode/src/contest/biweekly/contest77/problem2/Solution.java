package contest.biweekly.contest77.problem2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-30 22:29
 **/
public class Solution {
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) return 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }
        int res = 0;
        long min = Long.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            sum2 -= nums[i];
            long backSum;
            if (i == n - 1){
                backSum = 0;
            }else{
                backSum = (long)(sum2)/(n-i-1);
            }
            long tmp = Math.abs((long)(sum1)/(i+1)- backSum );
            if (tmp < min){
                res = i;
                min = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
