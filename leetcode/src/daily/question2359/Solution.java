package daily.question2359;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = bfs(edges, node1);
        System.out.println(Arrays.toString(dis1));
        int[] dis2 = bfs(edges, node2);
        System.out.println(Arrays.toString(dis2));

        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < edges.length; i++) {
            if ((dis1[i] != -1 && dis2[i] != -1) && Math.max(dis1[i], dis2[i]) < min) {
                min = Math.max(dis1[i], dis2[i]);
                res = i;
            }
        }
        return res;
    }

    private int[] bfs(int[] edges, int startNode) {
        int n = edges.length;
        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dis, -1);
        int steps = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        // initial
        queue.offer(startNode);
        dis[startNode] = 0;
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                int nxt = edges[curr];
                if (nxt != -1 && !visited[nxt]) {
                    queue.offer(nxt); // to offer nxt, so examine visited[nxt]
                    visited[nxt] = true;
                }
                dis[curr] = steps;
            }
            steps += 1;
        }
        return dis;
    }
}
