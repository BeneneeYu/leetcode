package binaryTreeAndRecursion.basicTraversal.question144;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * @author: Shen Zhengyu
 * @create: 2022-04-18 10:45
 **/
public class Solution {
    ArrayList<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        return list;
    }

    private void helper(TreeNode node) {
        if (null == node) return;
        list.add(node.val);
        helper(node.left);
        helper(node.right);
    }

    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (null != curr || !stack.isEmpty()) {
            while (null != curr) {
                // visit the node
                list.add(curr.val);
                // for future revisit
                stack.push(curr);
                // dig into left child
                curr = curr.left;
            }
            // no more left child nodes, visit the right child nodes
            curr = stack.pop();
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> preorderTraversalIteratively2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                // read parent node first
                result.add(node.val);
                stack.push(node.right);
                // popped before right, if left child node exists, always visit it
                stack.push(node.left);
            }
        }
        return result;
    }
}
