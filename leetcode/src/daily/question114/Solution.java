package daily.question114;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-27 22:55
 **/
public class Solution {
    ArrayList<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        visit(root);
        TreeNode parent = root;
        for (int i = 1; i < list.size(); i++) {
            parent.left = null;
            parent.right = list.get(i);
            parent = parent.right;
        }
    }

    private void visit(TreeNode node){
        if (null == node) return;
        list.add(node);
        visit(node.left);
        visit(node.right);
    }
}
