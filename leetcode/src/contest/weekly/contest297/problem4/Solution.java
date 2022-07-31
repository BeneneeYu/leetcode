package contest.weekly.contest297.problem4;

import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-12 10:25
 **/
public class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<Integer>[] count = new HashSet[26];
        for (int i = 0; i < 26; ++i)
            count[i] = new HashSet<>();
        for (String s : ideas)
            count[s.charAt(0) - 'a'].add(s.substring(1).hashCode());
        long res = 0;
        // for any two characters (not counting duplicated)
        for (int i = 0; i < 26; ++i)
            for (int j = i + 1; j < 26; ++j) {
                long c1 = 0, c2 = 0;
                for (int c : count[i]) // all hashcode of postfix started with char_i
                    if (!count[j].contains(c)) c1++; // a valid
                for (int c : count[j])
                    if (!count[i].contains(c)) c2++;
                res += c1 * c2;
            }
        return res * 2; // pair, swapped names can be different
    }
}
