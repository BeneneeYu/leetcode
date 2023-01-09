# Question

Given string num representing a non-negative integer `num`, and an integer `k`, return *the smallest possible integer after removing* `k` *digits from* `num`.

# Basic

For two numbers with the same length, the leftmost different digit determines their relative relationship. For example, `laxxx > lbxxx` if `a > b`. So that we should make sure that the former digit is as small as possible.

# Strategy

When the number of deleted digit is 1, we can compare every digit with its left adjacent  digit.

A kind of greedy strategy to delete a digit is that delete the first digit that bigger than its right adjacent digit.

Based on which we can implement `k` times so that we solve the question.

The worst time complexity is $O(nk)$, when the digit sequence is ascending, so we should accelerate it.

# Optimization

Consider construct the answer from left to right by increment. We can maintain the current sequence in a stack, element in which represents the smallest integer that we can construct after deletion of no more than k digits and by the current position. From the above, the elements are ascending or equal from the stack bottom to stack top.

We will not delete any digit until we find a digit that smaller than its left neighrbour. If we meet, delete the former digits until the top element is not bigger.

For every digit, if the digit is smaller than top element in stack, we pop the top element, until:

- The stack is empty.
- The new top element is not bigger than current number.
- K digits are already deleted.

After which,

- If we delete m digits and m < k, delete k-m digits from the tail.
- Delete leading zero.
- Return 0 if the sequence is null.