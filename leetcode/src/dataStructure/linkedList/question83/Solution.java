package dataStructure.linkedList.question83;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-28 18:13
 **/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head) return head;
        ListNode node = head;
        while (null != node.next){
            if (node.val == node.next.val){
                node.next = node.next.next; // no matter if node.next.next is null;
            }else{
                node = node.next;
            }
        }
        return head;
    }
}