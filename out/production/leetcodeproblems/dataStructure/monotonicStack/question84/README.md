# Question

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return *the area of the largest rectangle in the histogram*.

# Thoughts

The core rule is to pay attention to the largest rectangle area that based on the height of every bar.

When we detect forward, the time when we meet the first bar that has a lower height can we stop detecting and decide the width.

When we save data, we scan from left to right, while when we calculate the result, we scan from right to left. When the height and width of a bar is used, we don't need it anymore because the right-to-left scan can't be affected for the height limit in the left-to-right scan and we can pop it. So we can use **Stack** data structure.

This algorithm requires single scan, every time we calculate the maximum width, we do not use traversal, instead of which is the index in stack.

methods in `Deque`

- pollLast(): Retrieve and remove the last element in deque.
- peekLast(): Retrieve the last element in deque.

# Solution

What we want to figure out is the maximum breadth that applies to the height of each bar, the height of rectangle must be the height of the bar.

1. Do a traversal on bar chart, we can't decide the rectangle with maximum area with height of  `bar[0]`.
2. Move forward, assume that the height of `bar[1]` is smaller than `bar[0]`, the extension is stuck, so we can determine the rectangle.
3. If we encounter several bars with higher height when moving forward, after which we encounter a lower height bar, we can determine the rectangle with the height of bars in the front. In short, we found that as long as the height of the current column is strictly smaller than that of the previous column, the maximum width of some columns before it can be determined, and the order of the determined column width is from right to left, which tells us that the information to be recorded during traversal is the subscript of the traversed column. The difference between the subscripts of the two columns on the left and right is the maximum width of the rectangle with the largest area.
4. After one traversal, we should handle the left elements in stack.

