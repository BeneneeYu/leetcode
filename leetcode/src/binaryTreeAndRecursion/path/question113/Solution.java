package binaryTreeAndRecursion.path.question113;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * @author: Shen Zhengyu
 * @create: 2022-07-21 13:45
 **/
public class Solution {
    List<List<Integer>> result;
    Deque<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        dfs(root, 0, targetSum);
        return result;
    }

    private void dfs(TreeNode node, int sum, int targetSum) {
        if (null == node) return;
        sum += node.val;
        path.add(node.val);
        if (null == node.left && null == node.right && sum == targetSum) {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left, sum, targetSum);
        dfs(node.right, sum, targetSum);
        path.pollLast(); // backtrack, try another path and eliminate the influence of thisNode in dfs
    }
}
