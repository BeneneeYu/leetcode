package dataStructure.linkedList.question36JZoffer;


/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2020-08-19 21:59
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next != null ? p1.next : pHead2;
            p2 = p2.next != null ? p2.next : pHead1;
        }
        return p1;
    }

    public static void main(String[] args) {
        //
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode2;
        //    System.out.println((new Solution()).FindFirstCommonNode(listNode,listNode4));
        System.out.println((new Solution()).LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        int index = 0;
        int[] children = new int[n];
        for (int i = 0; i < n-1; i++) {
            int count = 0;
            while (count < m - 1) {
                while (true) {
                    if (children[index] == 0) {
                        count++;
                        index++;
                        while (true) {
                            if (index >= n) {
                                index = 0;
                            }
                            if(children[index] == -1){
                                index++;
                            }else{
                                break;
                            }
                            if (index >= n) {
                                index = 0;
                            }
                        }
                        break;
                    } else {
                        index++;
                        if (index >= n) {
                            index = 0;
                        }
                        continue;
                    }
                }
            }
            children[index] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (children[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
