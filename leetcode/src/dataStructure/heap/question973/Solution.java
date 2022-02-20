package dataStructure.heap.question973;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-20 13:44
 **/
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        if (null == points || k > points.length) return result;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((int[] p1, int[] p2) -> (p2[1] - p1[1]));
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{i, calDistanceSquare(points[i])});
        }
        for (int i = k; i < points.length; i++) {
            int tmpDistance = calDistanceSquare(points[i]);
            if (tmpDistance < maxHeap.peek()[1]) {
                maxHeap.poll();
                maxHeap.offer(new int[]{i, calDistanceSquare(points[i])});
            }
        }
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result[i] = points[maxHeap.poll()[0]];
        }
        return result;
    }

    private int calDistanceSquare(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
