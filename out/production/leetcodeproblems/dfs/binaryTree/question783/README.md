# Question

Given the `root` of a Binary Search Tree (BST), return *the minimum difference between the values of any two different nodes in the tree*.

# Ideas

DFS

Do recursion the the most left node, after which start comparing temporary result and difference between node value and previous fetched value, fetch the new node value and store it to variale prev. 