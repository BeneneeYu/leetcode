package dfs.permutation.question39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * @author: Shen Zhengyu
 * @create: 2022-02-17 11:19
 **/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> usedNum = new ArrayList<>();
        dfs(candidates, target, result, usedNum, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> usedNum, int index){
        if (index >= candidates.length) return;
        if (target == 0){
            result.add(new ArrayList<>(usedNum));
            return;
        }
        dfs(candidates, target, result, usedNum, index + 1);
        int left = target - candidates[index];
        if (left >= 0){
            usedNum.add(candidates[index]);
            dfs(candidates, left, result, usedNum, index);
            System.out.println(usedNum);
            usedNum.remove(usedNum.size() - 1); // remove after return
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.combinationSum(new int[]{2,3,5}, 8);
    }
}
