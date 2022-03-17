package dataStructure.stack.question856;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-17 08:09
 **/
public class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(0);
            } else {
                int tmpScore = stack.pop();
                int overallScore = stack.pop();
                if (tmpScore == 0) {
                    tmpScore = 1;
                } else {
                    tmpScore *= 2;
                }
                stack.push(overallScore + tmpScore);
            }
        }
        return stack.peek();
    }
}
