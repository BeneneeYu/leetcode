package daily.question456;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Leetcode
 * @description: Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * @author: Shen Zhengyu
 * @create: 2022-05-07 11:45
 **/
public class Solution {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            // if potential (j,k) exists, j is stack.peekLast() and k is popped
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // k is decreasing, k = pollLast() because smaller numbers are pushed consecutively
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}
