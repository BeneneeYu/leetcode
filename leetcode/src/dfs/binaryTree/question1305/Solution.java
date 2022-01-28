package dfs.binaryTree.question1305;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-26 09:45
 **/
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) < list2.get(i2)) {
                result.add(list1.get(i1));
                i1++;
            } else {
                result.add(list2.get(i2));
                i2++;
            }
        }
        if (i1 < list1.size()) {
            while (i1 < list1.size()) {
                result.add(list1.get(i1));
                i1++;
            }
        }else{
            while (i2 < list2.size()) {
                result.add(list2.get(i2));
                i2++;
            }
        }
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (null == root) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

}
