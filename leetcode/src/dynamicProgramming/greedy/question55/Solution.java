package dynamicProgramming.greedy.question55;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-22 15:02
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        int furthestIndex = 0;
        int i = 0;
        int n = nums.length;
        while (i < n && i <= furthestIndex) {
            furthestIndex = Math.max(i + nums[i], furthestIndex);
            i += 1;
        }
        return furthestIndex >= n - 1;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        Solution s = new Solution();
        System.out.println(s.canJump(nums));
    }
}
