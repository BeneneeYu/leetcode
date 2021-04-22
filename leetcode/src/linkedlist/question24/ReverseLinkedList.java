package linkedlist.question24;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2020-07-23 15:31
 **/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        //维护一个帮助遍历链表的指针
        ListNode pointer = head;
        //将尾作为暂时的顶，它标识着新链表头
        ListNode top = new ListNode(head.val);
        //尾的next是null
        top.next = null;
        //当head后有元素时
        while (pointer.next != null){
            pointer = pointer.next;
            //插入一个新元素，元素值是pointer后的结点
            ListNode newTop = new ListNode(pointer.val);
            //next指向现在的顶
            newTop.next = top;
            //顶变成新顶
            top = newTop;
        }
        return top;
    }

    public void printList(ListNode head){
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
      ReverseLinkedList r = new ReverseLinkedList();
      r.printList(a);
      r.printList(r.reverseList(a));

  }
}
