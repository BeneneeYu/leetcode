package dfs.binaryTree.question783;

import dfs.binaryTree.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-15 10:02
 **/
public class Solution {
    Integer res = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if (null != root.left){
            minDiffInBST(root.left);
        }
        // pre is the value of left child node
        // or root is the right child node
        if (null != pre){
            res = Integer.min(res, root.val - pre);
        }
        pre = root.val;
        if (null != root.right){
            minDiffInBST(root.right);
        }
        return res;
    }
}
