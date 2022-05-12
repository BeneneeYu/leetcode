package dfs.permutation.question47;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-12 10:06
 **/
public class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        LinkedList<Integer> combination = new LinkedList<>();
        Integer n = nums.length;
        backtrack(combination, n, counter);
        return result;
    }

    private void backtrack(LinkedList<Integer> combination, Integer n, HashMap<Integer, Integer> counter) {
        if (combination.size() == n) {
            // deep copy cause the permutation will be backtracked
            result.add(new ArrayList<>(combination));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer times = entry.getValue();
            if (times == 0) {
                continue;
            }

            // added into current
            combination.addLast(num);
            counter.put(num, times - 1);

            // exploring
            backtrack(combination, n, counter);

            // revert the choice for the next exploration
            combination.removeLast();
            counter.put(num, times);
        }
    }
}
