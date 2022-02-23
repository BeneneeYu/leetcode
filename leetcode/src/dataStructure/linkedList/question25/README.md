# Question

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return *the modified list*.

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

## Example

```
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

![img](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)

# Details

Firstly, we should divide the list nodes to groups of k elements, and we can use a pointer `head` to point at head nodes of groups. Every time we move forward `head` k steps until it reaches the end. For every group, we reverse this list if it has more than `k` elements.

Before reversing the sublist, save its successor node and previous node.

After reversing the sublist, remeber to connect correctly.

# Solution