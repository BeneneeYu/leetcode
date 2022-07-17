# 99. Recover Binary Search Tree



# 105. Construct Binary Tree from Preorder and Inorder Traversal

## Recursion

The two key observations are:

1. Preorder traversal follows `Root -> Left -> Right`, therefore, given the preorder array `preorder`, we have easy access to the root which is `preorder[0]`.
2. Inorder traversal follows `Left -> Root -> Right`, therefore if we know the position of `Root`, we can recursively split the entire array into two subtrees.

**Algorithm**

- Build a hashmap to record the relation of `value -> index` for `inorder`, so that we can find the position of root in constant time.
- Initialize an integer variable `preorderIndex` to keep track of the element that will be used to construct the root.
- Implement the recursion function `arrayToTree` which takes a range of `inorder` and returns the constructed binary tree:
  - if the range is empty, return `null`;
  - initialize the root with `preorder[preorderIndex]` and then increment `preorderIndex`;
  - recursively use the left and right portions of `inorder` to construct the left and right subtrees.
- Simply call the recursion function with the entire range of `inorder`.

## Implementation

```java
public class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
```

# 106. Construct Binary Tree from Inorder and Postorder Traversal

```java
public class Solution {
    int postOrderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the postOrderIndex element as the root and decrement it
        int rootValue = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // build right and left subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.right = arrayToTree(postorder, inorderIndexMap.get(rootValue) + 1, right);
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootValue) - 1);
        return root;
    }
}
```

