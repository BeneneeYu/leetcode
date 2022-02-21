# Question

Given the heads of two singly linked-lists `headA` and `headB`, return *the node at which the two lists intersect*. If the two linked lists have no intersection at all, return `null`.

# Solution

## HashSet

Do traversal on list A, put every node in HashSet.

Do traversal on list B, check if the current node is in HashSet.

## Double Pointers

Maintain two pointers `pA` and `pB`. Firstly they point at `headA` and `headB`, do traversal on the two lists.

Every step we update both `pA` and `pB`:

- If `pA` is not null, move `pA` to the next node. If `pB` is not null, move `pB` to the next node.
- If `pA` is null, move `pA` to `headB`. If `pB` is null, move `pB` to `headA`.
- When `pA` and `pB` point at the same node, return it. When they point at null, return null.

It is based on the fact that if the two lists have intersection, the two pointer will travel distance of `a+b+x`, in which `a` is the length of individual part of `headA`, `x` is the length of common part.

