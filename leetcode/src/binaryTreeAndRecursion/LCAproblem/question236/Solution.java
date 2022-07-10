package binaryTreeAndRecursion.LCAproblem.question236;

import binaryTreeAndRecursion.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-08 15:50
 **/
public class Solution {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (null == node) {
            return false;
        }
        boolean leftFound = dfs(node.left, p, q);
        boolean rightFound = dfs(node.right, p, q);
        boolean isItself = node == p || node == q;
        if ((leftFound && rightFound) || (isItself && (leftFound || rightFound))) {
            ans = node;
        }
        return leftFound || rightFound || isItself;
    }


}
