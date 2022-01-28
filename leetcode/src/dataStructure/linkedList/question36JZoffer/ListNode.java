package dataStructure.linkedList.question36JZoffer;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2020-08-19 21:58
 */
public class ListNode {
  public int val;
  public ListNode next = null;

  @Override
  public String toString() {
    return "ListNode{" +
            "val=" + val +
            '}';
  }

  public ListNode(int val) {
    this.val = val;
  }
}
