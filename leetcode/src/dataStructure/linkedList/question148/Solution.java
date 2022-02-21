package dataStructure.linkedList.question148;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description: Given the head of a linked list, return the list after sorting it in ascending order.
 * @author: Shen Zhengyu
 * @create: 2022-02-20 14:39
 **/
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (null == head) {
            return null;
        }
        if (head.next == tail) {
            head.next = null; // prepare for merge, [mid, tail)
            return head; // head.next is in the other sub list, avoid duplication
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    // merge two sorted lists
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = dummyHead;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (null != tmp1 && null != tmp2) {
            if (tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (null != tmp1) {
            tmp.next = tmp1;
        } else {
            tmp.next = tmp2;
        }
        return dummyHead.next;
    }
}
