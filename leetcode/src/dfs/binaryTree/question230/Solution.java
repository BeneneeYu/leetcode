package dfs.binaryTree.question230;

import dfs.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * @author: Shen Zhengyu
 * @create: 2022-04-18 08:58
 **/
public class Solution {

    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1).val;
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (null == node) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    public int kthSmallest_optimized(TreeNode root, int k) {
        count = k;
        inorder_optimized(root);
        return number;
    }

    private void inorder_optimized(TreeNode node) {
        if (null == node) return;
        inorder_optimized(node.left);
        if (--count == 0) {
            number = node.val;
            return;
        }
        inorder_optimized(node.right);
    }

    public int kthSmallest_iterative(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            // inorder(node.left)
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            // --count;
            root = stack.pop();
            // stop when it finds the kth smallest node
            if (--k == 0) return root.val;
            // inorder(node.left)
            root = root.right;
        }
    }
}
