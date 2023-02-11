package daily.question1129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        List<Integer>[] reds = new ArrayList[n];
        List<Integer>[] blues = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            reds[i] = new ArrayList<>();
            blues[i] = new ArrayList<>();
        }

        for (int[] redEdge : redEdges) {
            int start = redEdge[0];
            reds[start].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            int start = blueEdge[0];
            blues[start].add(blueEdge[1]);
        }
        int len = 0;
        boolean[] nextRedVisited = new boolean[n];
        boolean[] nextBlueVisited = new boolean[n];
        boolean[][] nextVisited = {nextRedVisited, nextBlueVisited};
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int flag = 0;
        nextVisited[flag % 2][0] = true;
        res[0] = 0;
        // choose red edge first
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> next = flag % 2 == 1 ? reds[node] : blues[node];
                for (Integer nxt : next) {
                    if (nextVisited[flag % 2][nxt]) {
                        continue;
                    }else {
                        res[nxt] = Math.min(len, res[nxt]);
                        queue.offer(nxt);
                        nextVisited[flag % 2][nxt] = true;
                    }
                }
            }
            flag++;
        }
        // queue is empty now
        len = 0;
        flag = 1;
        nextRedVisited = new boolean[n];
        nextBlueVisited = new boolean[n];
        nextVisited[0] = nextRedVisited;
        nextVisited[1] = nextBlueVisited;
        queue.offer(0);
        nextVisited[flag % 2][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                List<Integer> next = flag % 2 == 1 ? reds[node] : blues[node];

                for (Integer nxt : next) {
                    if (nextVisited[flag % 2][nxt]) {
                        continue;
                    }else {
                        res[nxt] = Math.min(len, res[nxt]);
                        queue.offer(nxt);
                        nextVisited[flag % 2][nxt] = true;
                    }
                }
            }
            flag++;
        }
        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
}
