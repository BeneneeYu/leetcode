package dfs.binaryTree.question111;

import dfs.binaryTree.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-17 21:08
 **/
public class Solution {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // leaf node
        if (null == root.left && null == root.right){
            return 1;
        }
        // not a leaf node
        int minDepth = Integer.MAX_VALUE;
        if (null != root.left){
            minDepth = minDepth(root.left);
        }
        if (null != root.right){
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        // return minDepth + 1 to its parents
        return minDepth + 1;
    }
}
