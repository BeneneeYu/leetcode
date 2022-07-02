package dataStructure.monotonicStack.question402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-18 08:54
 **/
public class Solution {
    public String removeKdigits(String num, int k) {
        // use mono-increasing stack.
        Deque<Character> monotonicStack = new LinkedList<>();
        int len = num.length();
        char[] chars = num.toCharArray();
        for (int i = 0; i < len; i++) {
            char digit = chars[i];
            while (!(monotonicStack.isEmpty()) && k > 0 && digit < monotonicStack.peekLast()) {
                monotonicStack.pollLast();
                k -= 1;
            }
            monotonicStack.offerLast(digit);
        }
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                monotonicStack.pollLast();
            }
        }
        StringBuilder result = new StringBuilder();
        boolean skippedZero = false;
        while (!monotonicStack.isEmpty()) {
            char digit = monotonicStack.pollFirst();
            if (!skippedZero && digit == '0') {
                continue;
            }
            skippedZero = true;
            result.append(digit);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
