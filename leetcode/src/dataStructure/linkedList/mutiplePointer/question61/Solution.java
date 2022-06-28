package dataStructure.linkedList.mutiplePointer.question61;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-11 08:51
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k == 0) return head;
        ListNode cur = head;
        int n = 1;
        while (null != cur.next) {
            cur = cur.next;
            n += 1;
        }
        int left = n - k % n;
        if (left == n) return head;
        // link as a cycle
        cur.next = head;
        while (left > 0) {
            cur = cur.next;
            left -= 1;
        }
        // find the new head and cur off
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
