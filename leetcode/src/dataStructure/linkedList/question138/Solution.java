package dataStructure.linkedList.question138;

import dataStructure.linkedList.Node;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-17 22:28
 **/
public class Solution {
    HashMap<Node, Node> createdNodes = new HashMap<>();

    public Node copyRandomListBacktrack(Node head) {
        if (null == head) {
            return null;
        }
        if (!createdNodes.containsKey(head)) {
            Node headNew = new Node(head.val);
            createdNodes.put(head, headNew);
            headNew.next = copyRandomListBacktrack(head.next);
            headNew.random = copyRandomListBacktrack(head.random);
        }
        return createdNodes.get(head);
    }

    public Node copyRandomListSplit(Node head) {
        if (null == head) {
            return null;
        }
        // split
        for (Node node = head; null != node; node = node.next.next) {
            Node nodeCopy = new Node(node.val);
            nodeCopy.next = node.next;
            node.next = nodeCopy;
        }
        // random deepcopy
        for (Node node = head; null != node; node = node.next.next) {
            Node nodeCopy = node.next;
            nodeCopy.random = (node.random == null) ? null : node.random.next;
        }
        Node headNew = head.next;
        for (Node node = head; null != node; node = node.next) { // node = node.next cause the next is changed
            Node nodeNew = node.next;
            node.next = node.next.next; // restore original list
            nodeNew.next = (null == nodeNew.next) ? null : nodeNew.next.next; // link new list
        }
        return headNew;
    }
}
