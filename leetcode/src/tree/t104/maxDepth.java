package tree.t104;

import java.util.LinkedList;

public class maxDepth {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static int maxDepth(TreeNode root) {
    if (null == root){
        return 0;
    }
    return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static int maxDepth2(TreeNode root) {
        if (null == root){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int maxDepth = 0;
        while (!queue.isEmpty()){
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (null != temp.left) {
                    queue.add(temp.left);
                }
                if (null != temp.right){
                    queue.add(temp.right);
                }
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        maxDepth m = new maxDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        System.out.println(maxDepth2(root));
    }
}