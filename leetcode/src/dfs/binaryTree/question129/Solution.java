package dfs.binaryTree.question129;

import dfs.binaryTree.TreeNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-16 09:42
 **/
public class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs("", root);
        return sum;
//        return sum(root, 0);
    }

    private void dfs(String path, TreeNode node) {
        if (null == node) return;
        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(node.val);
        if (null == node.left && null == node.right) {
            while (pathSB.indexOf("0") == 0) {
                pathSB.deleteCharAt(0);
            }
            if (!pathSB.toString().equals("")) {
                sum += Integer.parseInt(pathSB.toString());
            }
        } else {
            dfs(pathSB.toString(), node.left);
            dfs(pathSB.toString(), node.right);
        }
    }

    public int sum(TreeNode n, int s) {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s * 10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}
