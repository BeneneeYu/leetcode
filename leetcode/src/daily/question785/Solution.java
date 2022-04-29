package daily.question785;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * @author: Shen Zhengyu
 * @create: 2022-04-29 08:34
 **/
public class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        valid = true;
        int n = graph.length; // num of nodes
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }
}
