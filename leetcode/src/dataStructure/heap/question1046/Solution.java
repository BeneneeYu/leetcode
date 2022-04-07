package dataStructure.heap.question1046;

import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-07 08:29
 **/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((Integer a, Integer b) -> b - a); // default least root heap
        if (null == stones) return 0;
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            heap.offer(heap.poll() - heap.poll());
        }
        return heap.poll();
    }
}
