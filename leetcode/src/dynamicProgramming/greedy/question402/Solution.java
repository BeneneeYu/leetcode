package dynamicProgramming.greedy.question402;

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
        Deque<Character> deque = new LinkedList<Character>();
        int len = num.length();
        char[] chars = num.toCharArray();
        for (int i = 0; i < len; i++) {
            char digit = chars[i];
            while (!(deque.isEmpty()) && k > 0 && deque.peekLast() > digit) { // we can do deletion
                deque.pollLast();
                k -= 1;
            }
            deque.offerLast(digit);
        }
        if (k > 0) { // deletion is not enough
            for (int i = 0; i < k; i++) {
                deque.pollLast();
            }
        }
        StringBuilder result = new StringBuilder();
        boolean isLeadingZeroSkipped = false;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (!(isLeadingZeroSkipped) && digit == '0') {
                continue;
            }
            isLeadingZeroSkipped = true;
            result.append(digit);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
