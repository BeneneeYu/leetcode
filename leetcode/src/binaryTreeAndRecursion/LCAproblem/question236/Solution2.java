package binaryTreeAndRecursion.LCAproblem.question236;

import binaryTreeAndRecursion.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-08 17:19
 **/
public class Solution2 {
    HashMap<Integer, TreeNode> parent;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();
        dfs(root);
        HashSet<Integer> visited = new HashSet<>();
        while (null != p) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (null != q) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return root;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }
}
