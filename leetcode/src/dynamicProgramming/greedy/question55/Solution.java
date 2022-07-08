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
        int len = nums.length;
        int rightMost = 0;
        for (int i = 0; i < len; i++) {
            if (i > rightMost) break; // actually the position can not be reached
            rightMost = Math.max(rightMost, nums[i] + i); // expand
            if (rightMost >= len - 1) return true; // can reach termination
        }
        return false;
    }
}
