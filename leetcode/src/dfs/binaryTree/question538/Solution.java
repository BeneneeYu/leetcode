package dfs.binaryTree.question538;

import dfs.binaryTree.TreeNode;

import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-16 08:35
 **/
public class Solution {
    // store the sum of bigger values in right subtree
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST_Iteration(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        // the core is visiting the nodes in value-descending order
        while (!stack.isEmpty() || null != node) {
            // if node == null, visit the peek of stack
            while (null != node) {
                // the parent node is handled after its right child nodes
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            // decreasing order
            node = node.left;
        }
        return root;
    }
}
