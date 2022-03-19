```java
public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        // To avoid corner case, we import dummy head.
        ListNode dummyHead = new ListNode(-101); // -100 <= val <= 100
        dummyHead.next = head;
        ListNode node = head;
        ListNode pred = dummyHead;
        while (null != node) {
            if (null != node.next && node.val == node.next.val) {
                while (null != node.next && node.val == node.next.val) {
                    node = node.next;
                }
                pred.next = node.next;
            } else {
                pred = pred.next;
            }
            node = node.next;
        }
        return dummyHead.next;
    }
```

When we find duplicates, we try to find the sublist.

The predecessor forwards when nothing is detected, when duplicates are detected, it freezes, the first duplicate node start forwarding until it reaches the end of the sublist, when we can set the next node of the predecessor as the next node of current node. So that all duplicates are eliminated.

