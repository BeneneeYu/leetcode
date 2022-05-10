package daily.question216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * @author: Shen Zhengyu
 * @create: 2022-05-10 11:35
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> nums = new ArrayList<>();

    // select k numbers from 9 numbers, and verify that if their sum is n
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) return result;
        dfs(1, 9, k, n);
        Deque<Integer> path = new ArrayDeque<>();//存储根节点开始的路径
        dfs3(1, k, path, n);
        return result;
    }

    private void dfs(int cur, int n, int k, int sum) {
        if (nums.size() + (n - cur + 1) < k || nums.size() > k) {
            return;
        }
        if (nums.size() == k) {
            int tempSum = 0;
            for (int num : nums) {
                tempSum += num;
            }
            if (tempSum == sum) {
                result.add(new ArrayList<Integer>(nums));
                return;
            }
        }
        nums.add(cur);
        dfs(cur + 1, n, k, sum);
        nums.remove(nums.size() - 1);
        dfs(cur + 1, n, k, sum);
    }

    public void dfs3(int begin, int k, Deque<Integer> path, int target) {
        if (target == 0 && path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if (begin * (k - path.size()) > target) return;
        for (int i = begin; i < 10; i++) {
            // not enough
            if (target - i < 0) return;
            // select
            path.addLast(i);
            // start new loop for choosing the next number
            dfs3(i + 1, k, path, target - i);
            // try another
            path.removeLast();
        }
    }
}
