package dataStructure.linkedList.question328;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 14:19
 **/
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (null != even && null != even.next) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
