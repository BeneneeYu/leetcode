package binaryTreeAndRecursion.judgeTreeForm.question98;

import binaryTreeAndRecursion.TreeNode;

import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @author: Shen Zhengyu
 * @create: 2022-04-22 08:28
 **/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // The bound should be passed by recursion to restrict the relation between all generations nodes
    private boolean isValidBST(TreeNode node, long lowerBound, long upperBound) {
        if (null == node) return true;
        if (node.val >= upperBound || node.val <= lowerBound) return false;
        return isValidBST(node.right, node.val, upperBound) && isValidBST(node.left, lowerBound, node.val);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        Integer prev = null;
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (null != prev) {
                if (root.val <= prev) return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
    // This method only verify the relation between two generations of nodes, it is wrong
//    public boolean isValidBST(TreeNode root) {
//        if (null == root) return true;
//        if (null != root.left && root.left.val >= root.val) {
//            return false;
//        }
//        if (null != root.right && root.right.val <= root.val) {
//            return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }
}
