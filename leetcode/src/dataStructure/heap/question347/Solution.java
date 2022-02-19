package dataStructure.heap.question347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-19 22:27
 **/
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return null;
        Map<Integer, Integer> times = new HashMap<>();
        for (int num : nums) {
            times.put(num, times.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Integer integer : times.keySet()) {
            int timesOfInteger = times.get(integer);
            if (queue.size() == k) {
                if (queue.peek()[1] < timesOfInteger) {
                    queue.poll();
                    queue.offer(new int[]{integer, timesOfInteger});
                }
            } else {
                queue.offer(new int[]{integer, timesOfInteger});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k && (!queue.isEmpty()); i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
