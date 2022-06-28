package contest.weekly.contest299.problem2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-26 10:28
 **/
public class Solution {
    public int countHousePlacements(int n) {
        int l = 1000000007;
        int a = 1, b = 1, c = 2;
        for (int i = 0; i < n; i++) {
            c = (a + b) % l;
            a = b;
            b = c;
        }
        // b * b may be overflow
        return (int) ((long) b * b % l);
    }
}
