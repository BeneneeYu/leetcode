package tree.t129;

import java.util.LinkedList;

public class sum
{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int sum = 0;
//    private void helper(TreeNode treeNode,int fatherVal){
//        if (null == treeNode) return;
//        int current = fatherVal * 10 + treeNode.val;
//        if (null == treeNode.left && null == treeNode.right){
//            sum += current;
//        }
//        helper(treeNode.left,current);
//        helper(treeNode.right,current);
//
//    }
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return sum;
//        helper(root, 0);
//        return sum;
//    }
        public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> queueNum = new LinkedList<>();
            queue.add(root);
            queueNum.add(0);
            while (queue.size()>0){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    Integer tempInt = queueNum.poll();
                    Integer val = 10 * tempInt + temp.val;

                    if (temp.left == null && temp.right == null){
                        sum+=val;
                        break;
                    }
                    if (temp.left != null){
                        queue.add(temp.left);
                        queueNum.add(val);
                    }
                    if (temp.right != null){
                        queue.add(temp.right);
                        queueNum.add(val);
                    }
                }

            }
        return sum;
    }
}
