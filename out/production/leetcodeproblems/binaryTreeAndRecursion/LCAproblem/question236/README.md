# Question

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”

# Idea

First the given nodes `p` and `q` are to be searched in a binary tree and then their lowest common ancestor is to be found. We can resort to a normal tree traversal to search for the two nodes. Once we reach the desired nodes `p` and `q`, we can backtrack and find the lowest common ancestor.

# Solution

## Recursive Approach

**Intuition**

The approach is pretty intuitive. Traverse the tree in a depth first manner. The moment you encounter either of the nodes `p` or `q`, return some boolean flag. The flag helps to determine if we found the required nodes in any of the paths. The least common ancestor would then be the node for which both the subtree recursions return a `True` flag. It can also be the node which itself is one of `p` or `q` and for which one of the subtree recursions returns a `True` flag.

$f_x$ represents if subtree of node `x` contains node `p` or node `q`. LCA `x` qualifies that $(f_l \&\& f_r) || ((x == p || x == q) \&\& (f_l || fr))$, which means `p` and `q` are in subtrees of `x`, or `x` is `p` or `q` and itself is an ancestor.

## Store Parent Nodes

1. Traverse the whole binary tree from the root node, and record the parent node pointer of each node with a hash table.
2. Start from the P node and continue to move to its ancestors, and use the data structure to record the visited ancestor nodes.
3. Similarly, we continue to move from node Q to its ancestors. If an ancestor has been visited, it means that this is the deepest common ancestor of P and Q, that is, LCA node.