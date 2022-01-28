package dataStructure.linkedList.question86;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description: Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author: Shen Zhengyu
 * @create: 2022-01-28 18:58
 **/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-101);
        ListNode l2 = new ListNode(-101);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode node = head;
        while (null != node){
            if (node.val < x){
                cur1.next = node;
                cur1 = cur1.next;
            }else{
                cur2.next = node;
                cur2 = cur2.next;
            }
            node = node.next;
        }
        // cur2 may be a middle node is the original list, so we must make its next node as null to avoid cycle.
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
    }
}
