package contest.weekly.contest303.problem4;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Leetcode
 * @description: You are given a 0-indexed positive integer array nums and a positive integer k.
 * <p>
 * A pair of numbers (num1, num2) is called excellent if the following conditions are satisfied:
 * <p>
 * Both the numbers num1 and num2 exist in the array nums.
 * The sum of the number of set bits in num1 OR num2 and num1 AND num2 is greater than or equal to k, where OR is the bitwise OR operation and AND is the bitwise AND operation.
 * Return the number of distinct excellent pairs.
 * <p>
 * Two pairs (a, b) and (c, d) are considered distinct if either a != c or b != d. For example, (1, 2) and (2, 1) are distinct.
 * <p>
 * Note that a pair (num1, num2) such that num1 == num2 can also be excellent if you have at least one occurrence of num1 in the array.
 * @author: Shen Zhengyu
 * @create: 2022-07-25 09:52
 **/

//bits(num1 OR num2) + bits(num1 AND num2) = bits(num1) + bits(num2)
public class Solution {
    public long countExcellentPairs(int[] A, int k) {
        long cnt[] = new long[30], res = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A)
            set.add(a);
        for (int a : set)
            cnt[Integer.bitCount(a)]++;
        for (int i = 1; i < 30; ++i)
            for (int j = 1; j < 30; ++j)
                if (i + j >= k)
                    res += cnt[i] * cnt[j];
        return res;
    }
}
