package dataStructure.stack.question1249;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 19:27
 **/
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.empty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.empty()) {
            while (!stack.empty()) {
                indexToRemove.add(stack.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
