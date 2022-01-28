package dataStructure.linkedList.question82;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description: Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * @author: Shen Zhengyu
 * @create: 2022-01-28 18:21
 **/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        // To avoid corner case, we import dummy head.
        ListNode dummyHead = new ListNode(-101); // -100 <= val <= 100
        dummyHead.next = head;
        ListNode node = head;
        ListNode pred = dummyHead;
        while (null != node) {
            if (null != node.next && node.val == node.next.val) {
                while (null != node.next && node.val == node.next.val) {
                    node = node.next;
                }
                pred.next = node.next;
            } else {
                pred = pred.next;
            }
            node = node.next;
        }
        return dummyHead.next;
    }
}
