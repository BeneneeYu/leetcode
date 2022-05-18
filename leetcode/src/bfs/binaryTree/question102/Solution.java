package bfs.binaryTree.question102;

import bfs.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-18 11:37
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNode = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                levelNode.add(tmp.val);
                if (null != tmp.left) {
                    queue.add(tmp.left);
                }
                if (null != tmp.right) {
                    queue.add(tmp.right);
                }
            }
            res.add(levelNode);
        }
        return res;
    }
}
