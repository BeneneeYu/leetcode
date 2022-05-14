package daily.question117;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-13 14:19
 **/
public class Solution {
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        if(null == root) return null;
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNodes = queue.size();
            Node prev = null;
            for (int i = 0; i < levelNodes; i++) {
                Node tmp = queue.poll();
                if (null != prev){
                    prev.next = tmp;
                }
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                prev = tmp;
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if(null == root) return null;
        Node cur = root;
        while (cur != null){
            // visit n level, and connect n+1 level
            Node dummy = new Node(0);
            // pre is in next level
            Node pre = dummy;
            // do traversal in this level because this level is a linked list
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                // next node in this level
                cur = cur.next;
            }
            // n+1 level is connected as a list
            cur = dummy.next;
        }
        return root;
    }
}
