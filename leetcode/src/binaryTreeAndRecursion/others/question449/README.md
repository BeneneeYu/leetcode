# Question

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a **binary search tree**. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

**The encoded string should be as compact as possible.**

# Idea

Given the "preorder/postorder traversal" and "inorder traversal" of a binary tree, the binary tree can be restored. For BST, given "preorder traversal" or "postorder traversal", we can get "inorder traversal" by sorting it. Therefore, only "preorder traversal" or "postorder traversal" of BST can meet the requirements of serialization and deserialization. 

In the array obtained by postorder traversal, the root node is at the end of the array, the nodes of the left subtree are smaller than the value of the root node, and the nodes of the right subtree are larger than the value of the root node. According to these properties, recursive functions can be designed to recover the binary search tree.