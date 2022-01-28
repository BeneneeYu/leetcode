package dataStructure.linkedList.question21;

import dataStructure.linkedList.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-28 15:44
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (null != list1 && null != list2){
            if (list1.val < list2.val){
                node.next = list1;
                node = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                node = list2;
                list2 = list2.next;
            }
        }
        node.next = null == list1? list2 : list1;
        return head.next;
    }
}
