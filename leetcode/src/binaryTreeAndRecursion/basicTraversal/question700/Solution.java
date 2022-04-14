package binaryTreeAndRecursion.basicTraversal.question700;

import binaryTreeAndRecursion.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-14 11:44
 **/
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        } else {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }

    public TreeNode searchBST_2(TreeNode root, int val) {
        while (null != root && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
