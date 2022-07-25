package contest.weekly.contest303.problem2;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-24 10:30
 **/
public class Solution {
    public int equalPairs(int[][] grid) {
        int res = 0;
        int n = grid.length;
        HashMap<String, Integer> rowMap = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt).append(".");
            }
            rowMap.put(sb.toString(), rowMap.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append(".");
            }
            res += rowMap.getOrDefault(sb.toString(), 0);
        }
        return res;
    }

}
