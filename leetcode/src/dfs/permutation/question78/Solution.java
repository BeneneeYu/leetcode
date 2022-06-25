package dfs.permutation.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-13 09:28
 **/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> curList, int[] nums, int start) {
        resultList.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            curList.add(num);
            backtrack(resultList, curList, nums, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
