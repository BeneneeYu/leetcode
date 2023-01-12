package daily.question1519;


import java.util.*;

// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
class Solution {
    int[] res;
    Map<Integer, List<Integer>> edgesMap;
    char[] label;
    int n;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        res = new int[n];
        label = new char[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            label[i] = labels.charAt(i);
        }
        edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            List<Integer> list0 = edgesMap.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> list1 = edgesMap.getOrDefault(node1, new ArrayList<Integer>());
            list0.add(node1);
            list1.add(node0);
            edgesMap.put(node0, list0);
            edgesMap.put(node1, list1);
        }
        helper(0, new boolean[n]);
        return res;
    }

    /**
     * @return int the number of same-label nodes
     */
    private int[] helper(int node, boolean[] visited) {
        int[] tmpOcc = new int[26];
        tmpOcc[label[node] - 'a'] += 1;
        visited[node] = true;
        List<Integer> next = edgesMap.getOrDefault(node, new ArrayList<>());
        if (next.isEmpty()){
            res[node] = 1;
        }else{
            for (Integer ne : next) {
                if (visited[ne]) continue;
                int[] tmpSubOcc = helper(ne, visited);
                for (int i = 0; i < 26; i++) {
                    tmpOcc[i] += tmpSubOcc[i];
                }
            }
            res[node] = tmpOcc[label[node] - 'a'];
        }
        return tmpOcc;
    }
}