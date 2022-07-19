package contest.weekly.contest302.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-17 11:35
 **/
public class Solution {
    public int minOperations(int[] A, int[] numsDivide) {
        int g = numsDivide[0], tmp;
        for (int a : numsDivide) {
            while (a > 0) { // g = gcd(g, a)
                tmp = g % a;
                g = a;
                a = tmp;
            }
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] <= g; ++i)
            if (g % A[i] == 0)
                return i;
        return -1;
    }
}
