# Question

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

**Clarification:** The input/output format is the same as [how LeetCode serializes a binary tree](https://leetcode.com/faq/#binary-tree). You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

# Ideas

Serialize: Use pre-order traversal, append the node it self, append the left subtree string and the right subtree string successively.

Deserialize: Generate the parent node, resolve the left subtree and the right subtree successively and assign them to child nodes.

**Difference** between reconstruct the tree [#105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) **preorder/postorder + inorder** and this problem which just uses **preorder**

1. [#105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) preorder/postorder + inorder: **why we have to use 2 lists/traversals?**
   The lists **does not preserve the null**, so we do not have an indicator to check if a node is in the left subtree or right subtree, so 2 traversals are needed.
2. But for this problem, we can preserve `null`, so we can reconstruct by just using 1 list, i.e. preorder list.