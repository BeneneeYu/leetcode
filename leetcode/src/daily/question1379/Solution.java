package daily.question1379;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-17 10:27
 **/
public class Solution {
    TreeNode res;
    TreeNode target;

    public final TreeNode getTargetCopyBFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue_o = new LinkedList<>();
        Queue<TreeNode> queue_c = new LinkedList<>();
        queue_o.add(original);
        queue_c.add(cloned);
        while (!queue_o.isEmpty()){
            TreeNode node_o = queue_o.poll();
            TreeNode node_c = queue_c.poll();
            if (node_o == target){
                return node_c;
            }
            if (node_o.left != null){
                queue_c.add(node_c.left);
                queue_o.add(node_o.left);

            }
            if (node_o.right != null){
                queue_c.add(node_c.right);
                queue_o.add(node_o.right);

            }
        }
        return null;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return res;
    }

    public void inorder(TreeNode o, TreeNode c){
        if (null != o){
            inorder(o.left, c.left);
            if (o == target){
                res = c;
                return;
            }
            inorder(o.right, c.right);
        }
    }
}
