package dataStructure.linkedList.question234;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-21 22:51
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }
        ListNode tailOfFirstHalf = findMiddleNode(head);
        ListNode headOfSecondHalf = reverseList(tailOfFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = headOfSecondHalf;
        while (p2 != null) {
            if (p1.val != p2.val) {
                tailOfFirstHalf.next = reverseList(headOfSecondHalf);
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        tailOfFirstHalf.next = reverseList(headOfSecondHalf);
        return true;
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode findMiddleNode(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
