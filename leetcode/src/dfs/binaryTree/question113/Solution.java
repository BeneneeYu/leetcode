package dfs.binaryTree.question113;

import dfs.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-09 19:49
 **/
public class Solution {
    List<List<Integer>> resultList = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return resultList;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (null == root) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (null == root.left && null == root.right && targetSum == 0){
            resultList.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast(); // backtrack, try another path and eliminate the influence of thisNode in dfs
    }
}
