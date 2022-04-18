package binaryTreeAndRecursion.basicTraversal.question94;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * @author: Shen Zhengyu
 * @create: 2022-04-18 10:31
 **/
public class Solution {
    ArrayList<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        return list;
    }

    private void helper(TreeNode node) {
        if (null == node) return;
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }

    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // We push all the left children of root into the stack until there's no more nodes.
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }
            // Then we pop from the stack which we'd call cur.
            curr = stack.pop();
            // Add cur to result list
            list.add(curr.val);
            // Recursively call pushAllLeft() on cur's right child.
            curr = curr.right;
        }
        return list;
    }
}
