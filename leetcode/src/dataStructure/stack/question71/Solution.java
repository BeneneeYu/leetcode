package dataStructure.stack.question71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-14 09:16
 **/
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] names = path.split("/");
        for (String name : names) {
            if ("..".equals(name)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!".".equals(name) && name.length() > 0) {
                deque.offerLast(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) sb.append("/");
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
        return sb.toString();
    }
}
