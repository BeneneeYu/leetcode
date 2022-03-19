# Question

Given the `root` of a binary tree, return *the **maximum width** of the given tree*.

The **maximum width** of a tree is the maximum **width** among all levels.

The **width** of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is **guaranteed** that the answer will in the range of **32-bit** signed integer.

# Solution

It's not enough to calculate the length of queue of nodes in every level because their position is not settled.

Use AnnotatedNode to record the information of every node so that we can calculate the width.

