package bfs.binaryTree.question107;

import bfs.binaryTree.TreeNode;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-26 17:33
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> res = new LinkedList<List<Integer>>();
        if (null == root) {
            return new LinkedList<>(res);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                levelNodes.add(tmp.val);
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
            }
            res.addFirst(levelNodes);
        }
        return new LinkedList<>(res);
    }
}
