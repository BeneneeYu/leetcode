# Question

Given an integer `n`, return *all the structurally unique **BST'**s (binary search trees), which has exactly* `n` *nodes of unique values from* `1` *to* `n`. Return the answer in **any order**.

# Solution

The key property of a binary search tree is that the value of the root node is greater than that of all nodes of the left subtree and less than that of all nodes of the right subtree, and the left subtree and the right subtree are also binary search trees.

Therefore, when generating all feasible binary search trees, assuming that the current sequence length is `N`, if we enumerate the value of the root node as `i`, then according to the nature of the binary search tree, we can know that the set of node values of the left subtree is `[0...i-1]`,and the set of node values of the right subtree is `[i+1...n]`. Compared with the original problem, the generation of left subtree and right subtree is a sub problem with reduced sequence length, so we can think of using backtracking method to solve this problem.

We define `generateTrees(start, end)`, generate all feasible BST of sequence $[start, end]$, we enumerate `i` in $[start, end]$ as root, and call `generateTrees(start, i-1)` and `generateTrees(i+1, end)`, link the nodes.