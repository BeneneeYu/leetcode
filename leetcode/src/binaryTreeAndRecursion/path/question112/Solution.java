package binaryTreeAndRecursion.path.question112;

import binaryTreeAndRecursion.TreeNode;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * @author: Shen Zhengyu
 * @create: 2022-07-21 13:43
 **/
public class Solution {
    // adding up while traversing
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null == root) return false;
        if(null != root.left){
            root.left.val = root.val + root.left.val;
        }
        if(null != root.right){
            root.right.val = root.val + root.right.val;
        }
        if(null == root.left && null == root.right){
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
