package binaryTreeAndRecursion.basicTraversal.question145;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * @author: Shen Zhengyu
 * @create: 2022-04-18 10:54
 **/
public class Solution {
    LinkedList<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        helper(root);
        return list;
    }

    private void helper(TreeNode node) {
        if (null == node) return;
        helper(node.left);
        helper(node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // reverse list
            list.addFirst(curr.val);
            if (null != curr.left) {
                stack.push(curr.left);
            }
            if (null != curr.right) {
                stack.push(curr.right);
            }
        }
        return list;
    }
}
