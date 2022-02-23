package dataStructure.stack.question20;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 15:34
 **/
public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        List<Character> left = Arrays.asList('(', '{', '[');
        List<Character> right = Arrays.asList(')', '}', ']');
        for (char aChar : chars) {
            int index = left.indexOf(aChar);
            if (index > -1) {
                stack.push(right.get(index));
            } else {
                if (stack.empty() || stack.pop() != aChar) { // if stack.pop() == aChar, valid and continue
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
