package dataStructure.linkedList.question25;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 15:03
 **/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (null != head) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (null == tail) { // reach the end
                    return dummyHead.next;
                }
            }
            ListNode next = tail.next; // ready for connect
            ListNode[] reverse = reverseList(head, tail); // new head and tail
            head = reverse[0];
            tail = reverse[1];
            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }
        return dummyHead.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
