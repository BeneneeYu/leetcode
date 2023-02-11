package daily.question787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 */
public class Solution {
    int res = Integer.MAX_VALUE;
    HashMap<Integer, List<int[]>> flightsMap;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        flightsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            flightsMap.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            flightsMap.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        helper(src, dst, 0, k + 1, 0);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private void helper(int curr, int dst, int steps, int k, int price) {
        System.out.println("Reach " + curr + " Price " + price);
        if (steps > k || (steps == k && curr != dst)) {
            return;
        }
        if (curr == dst) {
            res = Math.min(res, price);
        }
        List<int[]> flightsFromCurr = flightsMap.get(curr);
        for (int[] flight : flightsFromCurr) {
            helper(flight[0], dst, steps + 1, k, price + flight[1]);
        }
    }
}
