package dataStructure.linkedList.question2;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-28 14:48
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        // double pointer
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10; // break the limit that two numbers are in [1,9]
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbersMyOwnCode(ListNode l1, ListNode l2) {
        boolean over = false;
        ListNode head = new ListNode(); // dummy node
        ListNode cur = head;
        while (null != l1 && null != l2) {

            int sum = l1.val + l2.val;
            if (over) sum++;
            if (sum >= 10) {
                over = true;
                sum -= 10;
            } else {
                over = false;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }

        // one of the list reach the tail
        if (null == l1) {
            while (null != l2) {
                int sum = l2.val;
                if (over) sum++;
                if (sum >= 10) {
                    over = true;
                    sum -= 10;
                } else {
                    over = false;
                }
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = node;
                l2 = l2.next;
            }
        } else {
            while (null != l1) {
                int sum = l1.val;
                if (over) sum++;
                if (sum >= 10) {
                    over = true;
                    sum -= 10;
                } else {
                    over = false;
                }
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = node;
                l1 = l1.next;
            }
        }
        // final work
        if (over) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }


}
