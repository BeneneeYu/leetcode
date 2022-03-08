package dynamicProgramming.greedy.question45;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-08 10:13
 **/
public class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        // i < length - 1 because when i == length - 1, it reaches the tail
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                steps += 1;
                end = maxPosition;
            }
        }
        return steps;
    }
}
