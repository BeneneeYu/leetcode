package binaryTreeAndRecursion.iterator.question285;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-12 16:03
 **/
public class Solution {
    private TreeNode ans;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return ans;
    }

    private void inorder(TreeNode root, TreeNode p) {
        // already found the answer
        if (null == root || null != ans) return;
        inorder(root.left, p);
        // have not visited successor yet, because it's BST, it's the first node with bigger value
        if (null == ans && p.val < root.val) ans = root;
        inorder(root.right, p);
    }

    public TreeNode inorderSuccessorIteration(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}
