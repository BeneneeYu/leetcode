package dataStructure.linkedList.question24;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-16 10:43
 **/
public class Solution {
    public ListNode swapPairsRecursion(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode second = head.next;
        head.next = swapPairsRecursion(second.next);
        second.next = head;
        return second;
    }

    public ListNode swapPairsIteration(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pointer = dummyHead;
        while (null != pointer.next && null != pointer.next.next) {
            ListNode first = pointer.next;
            ListNode second = pointer.next.next;
            pointer.next = second;
            first.next = second.next;
            second.next = first;
            pointer = first;
        }
        return dummyHead.next;
    }

    public void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print(head.val);
        System.out.println();
    }

    public static void main(String[] args) {
        //
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = null;
        Solution s = new Solution();
//        s.printList(s.swapPairsIteration(a));
        s.printList(s.swapPairsRecursion(a));

    }
}
