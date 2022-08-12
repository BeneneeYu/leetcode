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
    HashMap<Integer, TreeNode> parent = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        HashSet<Integer> visited = new HashSet<>();
        // from bottom to top
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        // the first encountered node is lca
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return root;
    }

    // get all the node-parent relationship
    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
