package contest.weekly.contest303.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-24 10:29
 **/
public class Solution {
    public char repeatedCharacter(String s) {
        int[] times = new int[26];
        for (char c : s.toCharArray()) {
            if (times[c - 'a'] == 1) return c;
            times[c - 'a'] += 1;
        }
        return 'a';
    }
}
