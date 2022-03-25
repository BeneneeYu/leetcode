package dynamicProgramming.greedy.question1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-25 09:36
 **/
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // if aCost > bCost, he should go to city b
        // to implement greedy, sort by aCost - bCost and select half
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int totalCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            totalCost += costs[i][0];
            totalCost += costs[i + costs.length / 2][1];
        }
        return totalCost;
    }
}
