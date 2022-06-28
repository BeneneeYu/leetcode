# Question

You are given the `root` of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return *the minimum number of cameras needed to monitor all nodes of the tree*.

# Solution

**Greedy:** To reduce the number of installed cameras, try to install cameras on parent nodes of leaf nodes, which requires bottom-up deduction. Post-order traversal is bottom-up.

**Dynamic Programming:** How the states transfer? Three states

- A node is not covered (0)
- A node is installed with camera (1)
- A node is covered (2)

To reduce the number, mark null nodes as installed camera so that cameras are not installed on leaf nodes.

**Deduction**: The termination condition is null node, return 2.

Four situations for a single node:

1. Both of the two children nodes are covered (let its parent node covers it)
2. At least one of the children nodes are not covered (it should install camera)
3. At least one of the children nodes are camera-installed (return covered status)