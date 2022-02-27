package bfs.binaryTree.question662;

import bfs.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-27 10:55
 **/
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0, 0));
        int curDepth = 0;
        int left = 0; // start pos of every level
        int ans = 0; // end pos - left pos + 1
        while (!queue.isEmpty()) {
            AnnotatedNode tmp = queue.poll();
            if (null != tmp.node) {
                queue.add(new AnnotatedNode(tmp.node.left, tmp.depth + 1, tmp.pos * 2));
                queue.add(new AnnotatedNode(tmp.node.right, tmp.depth + 1, tmp.pos * 2 + 1));
                if (curDepth != tmp.depth) { // new level
                    curDepth = tmp.depth;
                    left = tmp.pos;
                }
                ans = Math.max(ans, tmp.pos - left + 1);
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;

    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}