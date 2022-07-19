package dfs.permutation.question77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * @author: Shen Zhengyu
 * @create: 2022-07-18 12:54
 **/
public class Solution {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }

    private void dfs(int start, int n, int k) {
        if (path.size() + n - start + 1 < k) return;
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        dfs(start + 1, n, k);
        path.remove(path.size() - 1);
        dfs(start + 1, n, k);
    }
}
