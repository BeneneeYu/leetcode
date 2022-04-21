package binaryTreeAndRecursion.iterator.question173;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-20 08:20
 **/
public class BSTIterator {
    ArrayList<TreeNode> inOrderList;
    int index = 0;

    public BSTIterator(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        inOrderList = new ArrayList<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inOrderList.add(root);
            root = root.right;
        }
    }

    public int next() {
        return inOrderList.get(index++).val;
    }

    public boolean hasNext() {
        return index < inOrderList.size();
    }
}
