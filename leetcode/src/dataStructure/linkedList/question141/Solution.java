package dataStructure.linkedList.question141;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-20 14:00
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            // relative distance--
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (null == head || null == head.next) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
