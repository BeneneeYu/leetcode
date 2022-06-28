package dataStructure.linkedList.question203;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description: Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * @author: Shen Zhengyu
 * @create: 2022-02-21 13:30
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode prev = dummyHead;
        while (null != cur) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
