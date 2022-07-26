package contest.biweekly.contest83.problem4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-23 22:26
 **/
public class Solution {
    public int shortestSequence(int[] A, int k) {
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
            if (k == set.size()) {
                res += 1;
                set.clear();
            }
        }
        return res;
    }
}
