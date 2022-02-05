package dataStructure.heap.question23;

import dataStructure.heap.ListNode;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-05 08:35
 **/
public class Solution {
    class Status implements Comparable<Status> {
        int val;
        ListNode node;

        Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    PriorityQueue<Status> nodes = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for (ListNode node : lists) {
            if (null != node) {
                nodes.add(new Status(node.val, node));
            }
        }
        while (!nodes.isEmpty()) {
            Status s = nodes.poll();
            tail.next = s.node;
            tail = tail.next;
            if (null != s.node.next) {
                nodes.add(new Status(s.node.next.val, s.node.next));
            }
        }
        return dummyHead.next;
    }

    public ListNode mergeKListsLogK(ListNode[] lists) {
        if (lists.length == 0) return null;
        int high = lists.length - 1;
        int low = 0;
        while (high > 0){
            int mid = high / 2;
            while (low < high){
                lists[low] = mergeTwoLists(lists[low], lists[high]);
                low += 1;
                high -= 1;
            }
            low = 0;
            high = mid;
        }
        return lists[0];
    }

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
