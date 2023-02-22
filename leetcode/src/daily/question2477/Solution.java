package daily.question2477;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

public class Solution {
    long ans;
    List<List<Integer>> map = new ArrayList<>();
    int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        if (n == 1) return 0;
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        ans = 0;
        this.seats = seats;
        dfs(0, -1);
        return ans;
    }

    private int dfs(int node, int parent) {
        // node itself should be counted
        int children = 1;
        // dfs the child nodes of node
        for (Integer neighbor : map.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            // pass the children's influence
            children += dfs(neighbor, node);
        }
        // count to the result
        if (node != 0) {
            ans += (int) ((children + seats - 1) / seats);
        }
        return children;
    }
}

