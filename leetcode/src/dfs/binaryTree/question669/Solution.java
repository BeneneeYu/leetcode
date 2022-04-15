package dfs.binaryTree.question669;

import dfs.binaryTree.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-15 08:57
 **/
public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (null == root) return null;
        if (root.val < low) {
            root = root.right;
            // trim the right subtree and assign trimmed, correct root to the position
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            root = root.left;
            root = trimBST(root, low, high);
        } else {
            // the root should be kept and handle the two descendant nodes
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
