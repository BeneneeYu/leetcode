# BST Iterator

- Use **Non-recursion / Iteration** method to implement in-order traversal through a binary tree
- Commonly used for BST but not only for BST
- $O(n), O(n)$

## Template

```java
List<TreeNode> inorderTraversal(TreeNode root){
	List<TreeNode> inorder = new ArrayList<>();
	if(null == root) return inorder;
	// create a dummy node, right points at root
	// push it to the stack, dummy is current position of iterator
}
```

