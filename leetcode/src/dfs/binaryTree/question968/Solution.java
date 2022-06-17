package dfs.binaryTree.question968;

import dfs.binaryTree.TreeNode;

import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-17 09:51
 **/
public class Solution {
    int res;
    HashSet<TreeNode> covered;

    public int minCameraCover(TreeNode root) {
        res = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return res;
    }

    public int minCameraCoverDynamicProgramming(TreeNode root) {
        res = 0;
        if (0 == traversal(root)) {
            res += 1;
        }
        return res;
    }

    private int traversal(TreeNode node) {
        if (null == node) {
            return 2;
        }
        int left = traversal(node.left);
        int right = traversal(node.right);
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            res += 1;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (null != node) {
            dfs(node.left, node);
            dfs(node.right, node);

            // dfs returns
            if (null == parent && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right)) {
                res += 1;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}
