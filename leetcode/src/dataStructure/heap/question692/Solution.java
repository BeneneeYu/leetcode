package dataStructure.heap.question692;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-20 10:26
 **/
public class Solution {
    private class StringTimesPair {
        String str;
        int times;

        public StringTimesPair(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (k == 0) return result;
        HashMap<String, Integer> occurrences = new HashMap<>();
        for (String word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
        // min heap
        PriorityQueue<StringTimesPair> topKHeap = new PriorityQueue<>((StringTimesPair p1, StringTimesPair p2) -> (p1.times == p2.times ? p2.str.compareTo(p1.str) : p1.times - p2.times));
        for (String s : occurrences.keySet()) {
            int times = occurrences.get(s);
            topKHeap.offer(new StringTimesPair(s, times));
            if (topKHeap.size() > k) {
                topKHeap.poll();
            } // every time the space is not enough, remove the min value
        }
        while (!topKHeap.isEmpty()) {
            result.add(0, topKHeap.poll().str);
        }
        return result;
    }
}
