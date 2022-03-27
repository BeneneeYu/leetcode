package contest.weekly.contest286.problem4;

import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-27 18:28
 **/
public class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];
        return dp(piles, memo, 0, k);
    }

    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (memo[i][k] != null) return memo[i][k]; // the max value of situation: picking k coins from piles[i] to the last pile
        // not initialized yet
        int res = dp(piles, memo, i + 1, k); // pick 0 coins in piles[i]
        int cur = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) { // try to get different numbers of coins in piles[i]
            cur += piles.get(i).get(j); // start from only pick one coin in piles[i]
            res = Math.max(res, cur + dp(piles, memo, i + 1, k - j - 1));
        }
        return memo[i][k] = res;
    }
}
