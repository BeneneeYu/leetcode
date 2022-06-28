package dfs.permutation.question47;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-12 10:06
 **/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            // return all the permutations, traverse from 0
            for (int i = 0; i < nums.length; i++) {
                // if a number is used or duplicated, continue to next round
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                // use it now and go on
                backtrack(list, tempList, nums, used);
                // not use nums[i] now but afterwards
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
