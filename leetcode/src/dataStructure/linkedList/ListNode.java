package dataStructure.linkedList;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-28 15:45
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

