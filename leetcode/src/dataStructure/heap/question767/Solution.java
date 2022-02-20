package dataStructure.heap.question767;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-20 12:09
 **/
public class Solution {
    public String reorganizeString(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (char aChar : chars) {
            counts[aChar - 'a'] += 1;
        }
        int maxCount = Integer.MIN_VALUE;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }
        if (maxCount > (len + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((Character c1, Character c2) -> (counts[c2 - 'a'] - counts[c1 - 'a']));
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (maxHeap.size() > 1) {
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();
            res.append(c1);
            res.append(c2);
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            counts[index1] -= 1;
            if (counts[index1] > 0) {
                maxHeap.offer(c1);
            }
            counts[index2] -= 1;
            if (counts[index2] > 0) {
                maxHeap.offer(c2);
            }
        }
        if (maxHeap.size() > 0) {
            res.append(maxHeap.poll());
        }
        return res.toString();
    }
}
