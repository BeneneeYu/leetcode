package contest.weekly.contest291.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-01 10:18
 **/
public class Solution {
    public int minimumCardPickup(int[] cards) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(cards[i], new ArrayList<Integer>());
            list.add(i);
            map.put(cards[i], list);
        }
        for (ArrayList<Integer> value : map.values()) {
            if (value.size() == 1) continue;
            Collections.sort(value);
            for (int i = 0; i < value.size() - 1; i++) {
                res = Math.min(value.get(i + 1) - value.get(i) + 1, res);
            }
        }
        if (res == Integer.MAX_VALUE) res = -1;
        return res;
    }
}
