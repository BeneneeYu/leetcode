package dfs.permutation.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * @author: Shen Zhengyu
 * @create: 2022-06-24 19:59
 **/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            List<Integer> tmp = new ArrayList<>(cur);
            res.add(tmp);
        } else {
            for (int num : nums) {
                if (cur.contains(num)) {
                    continue;
                }
                cur.add(num);
                backtrack(res, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
