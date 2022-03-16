package dataStructure.stack.question946;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-16 10:01
 **/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p2 = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && p2 < popped.length & stack.peek() == popped[p2]) {
                stack.pop();
                p2++;
            }
        }
        return p2 == popped.length;
    }
}
