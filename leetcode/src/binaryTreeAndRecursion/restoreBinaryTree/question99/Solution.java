package binaryTreeAndRecursion.restoreBinaryTree.question99;


import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * @author: Shen Zhengyu
 * @create: 2022-04-19 10:26
 **/
public class Solution {
    public void recoverTreeImplicitly(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // has detected swapped nodes
            if (null != prev && root.val < prev.val) {
                y = root;
                if (null == x) {
                    // the first one
                    x = prev;
                } else {
                    // y is now the second one
                    break;
                }
            }
            prev = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    public void recoverTreeExplicitly(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        // get the in-order traversal sequence
        inorder(root, nums);
        // record the values swapped by mistake
        int[] swappedElements = findSwappedElements(nums);
        // assign the correct value to swapped position
        recover(root, 2, swappedElements[0], swappedElements[1]);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (null == root) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findSwappedElements(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                // first detected
                if (index1 == -1) {
                    index1 = i;
                } else {
                    // index1 - first, index2 - second
                    break;
                }
            }
        }
        return new int[]{nums.get(index1), nums.get(index2)};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (null != root) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}
