package dynamicProgramming.greedy.question991;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-23 08:48
 **/
public class Solution {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target += 1;
            } else {
                target /= 2;
            }
            steps += 1;
        }
        return steps + startValue - target;
    }
}
