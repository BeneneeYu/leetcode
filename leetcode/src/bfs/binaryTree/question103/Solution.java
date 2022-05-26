package bfs.binaryTree.question103;

import bfs.binaryTree.TreeNode;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-26 17:20
 **/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean ltr = true;
        while (!queue.isEmpty()) {
            int size = queue.size(); // or we can not handle a level of nodes
            Deque<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
                if (ltr) {
                    levelNodes.offerLast(tmp.val);
                } else {
                    levelNodes.offerFirst(tmp.val);
                }
            }
            res.add(new LinkedList<Integer>(levelNodes));
            ltr = !ltr;
        }
        return res;
    }
}
