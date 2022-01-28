package dataStructure.linkedList.question142;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-19 10:09
 **/
/*
Define the distance between head and the node where the cycle begins as A,
distance between the node where the cycle begins and the node two pointers meet as B,
the left distance in cycle as C.
when the two pointers meet A+B+n(B+C)=2(A+B) => A=C+(n-1)(B+C)
so that when two pointers meet, use another pointer ptr from head, when slow pointer and ptr meet, return
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast) { // The fast pointer reach the possible tail first.
            slow = slow.next;
            if (null != fast.next) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
