package dataStructure.linkedList.question92;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-29 11:57
 **/
public class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (null == head || null == head.next || left >= right) return head;
            ListNode dummyHead = new ListNode(-101);
            dummyHead.next = head;
            ListNode cur = head, prev = dummyHead;
            // cur points at the first node that should be reversed
            while (left > 1) {
                prev = cur;
                cur = cur.next;
                left--;
                right--;
            }
            ListNode con = prev, tail = cur;
            ListNode third = null;
            // normal reverse list
            while (right > 0) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
                right--;
            }
            // handle the outer connection, now prev is the head of new list, while cur is after the new list's tail
            con.next = prev;
            tail.next = cur;
            return dummyHead.next;
        }
}
