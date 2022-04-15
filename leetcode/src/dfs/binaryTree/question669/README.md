# Question

Given the `root` of a binary search tree and the lowest and highest boundaries as `low` and `high`, trim the tree so that all its elements lies in `[low, high]`. Trimming the tree should **not** change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a **unique answer**.

Return *the root of the trimmed binary search tree*. Note that the root may change depending on the given bounds.

# Ideas

When we handle node, if node.val > high, the right subtree of node should be trimmed, if node.val < low, the left subtree of node should be trimmed. Otherwise, node should remain, we handle the left descendant node and right descendant node.