The core rule is to pay attention to the largest rectangle area that based on the height of every bar.

When we detect forward, the time when we meet the first bar that has a lower height can we stop detecting and decide the width.

When we save data, we scan from left to right, while when we calculate the result, we scan from right to left. When the height and width of a bar is used, we don't need it anymore because the right-to-left scan can't be affected for the height limit in the left-to-right scan and we can pop it. So we can use **Stack** data structure.

This algorithm requires single scan, every time we calculate the maximum width, we do not use traversal, instead of which is the index in stack.

methods in `Deque`

- pollLast(): Retrieve and remove the last element in deque.
- peekLast(): Retrieve the last element in deque.