package dfs.binaryTree.question337;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-12-05 10:46
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
