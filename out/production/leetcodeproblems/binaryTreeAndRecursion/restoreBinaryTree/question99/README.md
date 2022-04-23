# Question

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

# Idea

# Explicit In-order Traversal

Consider the result of the mistake, it breaks the increasing trend in the result of in-order traversal.

In an increasing sequence, if two non-adjacent numbers are swapped, two index `i` make `ai < ai+1` false, or one index `i` makes it false.

# Implicit In-order Traversal

Find the nodes `x` and `y` which are swapped by mistake in the process of in-order traversal implicitly.

During the in-order traversal, we pay attention to the size relation between two adjacent values and adjust the relative position, after we adjust twice, we break the loop.

