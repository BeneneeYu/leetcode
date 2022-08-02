package daily.question378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-02 12:34
 **/
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else {
                    if (pq.peek() <= matrix[i][j]) {
                        break;
                    } else {
                        pq.add(matrix[i][j]);
                        pq.poll();
                    }
                }
            }
        }
        return pq.peek();
    }
}
