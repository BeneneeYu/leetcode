package dfs.binaryTree.question257;

import dfs.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-16 09:20
 **/
public class Solution {
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<TreeNode> currentPath = new ArrayList<>();
        dfs(currentPath, root);
        return paths;
    }

    private void dfs(List<TreeNode> currentPath, TreeNode node) {
        if (null != node) {
            currentPath.add(node);
            if (null == node.left && null == node.right) {
                paths.add(nodeList2String(currentPath));
            } else {
                dfs(currentPath, node.left);
                dfs(currentPath, node.right);
            }
            currentPath.remove(currentPath.size() - 1);
        }
    }

    private void dfs_concat(String path, TreeNode node) {
        if (null != node) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(node.val);
            if (null == node.left && null == node.right) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                dfs_concat(pathSB.toString(), node.left);
                dfs_concat(pathSB.toString(), node.right);
            }
        }
    }

    private String nodeList2String(List<TreeNode> nodeList) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode treeNode : nodeList) {
            sb.append("->").append(treeNode.val);
        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        root.left = leftChild;
        root.right = new TreeNode(3);
        leftChild.right = new TreeNode(5);
        Solution s = new Solution();
        for (String binaryTreePath : s.binaryTreePaths(root)) {
            System.out.println(binaryTreePath);
        }
    }
}
