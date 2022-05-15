package daily.question1302;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-15 11:08
 **/
public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (null != tmp.left) queue.add(tmp.left);
                if (null != tmp.right) queue.add(tmp.right);
            }
            if (queue.isEmpty()) return sum;
        }
        return root.val;
    }
}
