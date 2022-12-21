package template.graph.pathExists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description: There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 * @author: Shen Zhengyu
 * @create: 2022-12-20 00:40
 **/
public class Solution {
    List<Integer>[] adj;
    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        adj = new List[n];
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adj[src].add(dst);
            adj[dst].add(src);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited);
    }

    private boolean dfs(int vertex, int des, boolean[] visited){
        if (vertex == des){
            return true;
        }
        visited[vertex] = true;
        for(int next : adj[vertex]) {
            if (!visited[next] && dfs(vertex, des, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        adj = new List[n];
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adj[src].add(dst);
            adj[dst].add(src);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination) break;
            visited[node] = true;
            for(int adjNode : adj[node]){
                if (destination == adjNode) return true;
                if (!visited[adjNode]){
                    queue.offer(adjNode);
                    visited[adjNode] = true; // visit according to edge
                }
            }
        }
        return visited[destination];
    }

    public boolean validPathUF(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.uni(edge[0], edge[1]);
        }
        return uf.connect(source, destination);
    }

}
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void uni(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
