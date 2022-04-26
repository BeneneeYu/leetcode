package daily.question1584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description: You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].  The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.  Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * @author: Shen Zhengyu
 * @create: 2022-04-26 08:50
 **/
public class Solution {

    public int minCostConnectPointsKruskal(int[][] points) {
        int n = points.length; // the number of all the points
        ArrayList<int[]> allEdges = new ArrayList<>(); // [weight, startPointIndex, endPointIndex]
        for (int curNext = 0; curNext < n; curNext++) {
            for (int nextNext = curNext + 1; nextNext < n; nextNext++) {
                int weight = getManhattanDistance(points[curNext], points[nextNext]);
                int[] curEdge = new int[]{weight, curNext, nextNext};
                allEdges.add(curEdge);
            }
        }

        allEdges.sort((a, b) -> Integer.compare(a[0], b[0])); // edge weight increasing order

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;
        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (uf.union(node1, node2)) { // union success, will not form a cycle
                mstCost += weight; // include the edge in the MST
                edgesUsed++;
            }
        }
        return mstCost;
    }
    

    private int getManhattanDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    class UnionFind {
        public int[] group;
        public int[] rank;

        public UnionFind(int size) {
            group = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i) {
                group[i] = i;
            }
        }

        public int find(int node) {
            if (group[node] != node) {
                group[node] = find(group[node]);
            }
            return group[node];
        }

        public boolean union(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);

            // node1 and node2 already belong to same group.
            if (group1 == group2) {
                return false;
            }

            if (rank[group1] > rank[group2]) {
                group[group2] = group1;
            } else if (rank[group1] < rank[group2]) {
                group[group1] = group2;
            } else {
                group[group1] = group2;
                rank[group2] += 1;
            }

            return true;
        }
    }
}
