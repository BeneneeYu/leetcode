package binaryTreeAndRecursion.others.question199;

import binaryTreeAndRecursion.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-11 20:21
 **/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(null == root) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (null != tmp.left){
                    queue.add(tmp.left);
                }
                if (null != tmp.right){
                    queue.add(tmp.right);
                }
                if (size - 1 == i) res.add(tmp.val);
            }
        }
        return res;
    }
}
