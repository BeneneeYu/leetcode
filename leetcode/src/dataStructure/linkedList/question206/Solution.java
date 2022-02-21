package dataStructure.linkedList.question206;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-21 14:46
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        // This is not true because originalHead.next is not null and there will be a cycle
//        ListNode prev = head;
//        ListNode curr = head.next;

        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
