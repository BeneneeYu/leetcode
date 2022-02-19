package dataStructure.heap.question1675;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-19 10:35
 **/
public class Solution {
    public int minimumDeviation(int[] nums) {
        if (nums.length <= 1) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(11, new Comparator<Integer>() { //大顶堆，容量11
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        ;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            int numToAdd = num % 2 == 0 ? num : num * 2;
            queue.add(numToAdd);
            minValue = Math.min(minValue, numToAdd);
        }
        int res = queue.peek() - minValue;
        while (!(queue.isEmpty()) && (queue.peek() % 2 != 1)) {
            int maxValue = queue.poll();
            int tmp = maxValue / 2;
            queue.offer(tmp);
            minValue = Math.min(tmp, minValue);
            res = Math.min(res, queue.peek() - minValue);
        }
        return res;
    }
}
