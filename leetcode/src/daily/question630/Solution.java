package daily.question630;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-23 18:18
 **/
public class Solution {
    public int scheduleCourse(int[][] courses) {
        // deadline increasing
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // root has longest duration
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) { // can add
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }

}
