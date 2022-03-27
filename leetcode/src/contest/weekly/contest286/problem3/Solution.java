package contest.weekly.contest286.problem3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-27 10:45
 **/
public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ret = new long[n];
        long base = (long) Math.pow(10, (intLength - 1) / 2);
        long to = (long) Math.pow(10, (intLength - 1) / 2 + 1);
        for (int i = 0; i < n; i++) {
            long u = base + queries[i] - 1;
            if (u >= to) { // //check if query is within range
                ret[i] = -1;
            } else { // expand the latter half
                long m = u;
                if (intLength % 2 == 1) m /= 10; // the mid number should only appear once
                long v = u;
                while (m > 0) {
                    v = v * 10 + m % 10;
                    m /= 10;
                }
                ret[i] = v;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.kthPalindrome(new int[]{2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6}, 1)));
        System.out.println(Arrays.toString(s.kthPalindrome(new int[]{58, 29, 358732919, 149198876, 246393513, 104605183, 18363825}, 9)));
    }
}
