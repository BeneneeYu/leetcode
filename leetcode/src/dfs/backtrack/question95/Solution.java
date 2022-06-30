package dfs.backtrack.question95;

import dfs.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @program: Leetcode
 * @description: Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * @author: Shen Zhengyu
 * @create: 2022-06-30 22:24
 **/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) { // return the root node
        List<TreeNode> allTrees = new LinkedList<TreeNode>(); // all shapes of BST whose nodes are in [start, end]
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode thisRoot = new TreeNode(i);
                    thisRoot.left = leftTree;
                    thisRoot.right = rightTree;
                    allTrees.add(thisRoot);
                }
            }
        }
        return allTrees;
    }
}
