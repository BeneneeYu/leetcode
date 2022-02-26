package bfs.graph.question847;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-26 09:15
 **/
public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int all = (int) Math.pow(2, n);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][all];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0];
            int mask = tuple[1];
            int dist = tuple[2];
            if (mask == all - 1) {
                ans = dist;
                break;
            }
            for (int i : graph[u]) {
                int maskTmp = mask | (1 << i);
                if (!seen[i][maskTmp]) {
                    queue.offer(new int[]{i, maskTmp, dist + 1});
                    seen[i][maskTmp] = true;
                }
            }
        }
        return ans;
    }
}
