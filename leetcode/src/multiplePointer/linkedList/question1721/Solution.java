package multiplePointer.linkedList.question1721;

import multiplePointer.linkedList.ListNode;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-04 08:38
 **/
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 1; i < k; i++) {
            node1 = node1.next;
        }
        ListNode tmp = node1.next;
        while (null != tmp) {
            node2 = node2.next;
            tmp = tmp.next;
        }
        int tmpVal = node1.val;
        node1.val = node2.val;
        node2.val = tmpVal;
        return head;
    }
}
