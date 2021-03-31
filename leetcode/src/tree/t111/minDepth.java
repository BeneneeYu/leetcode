package tree.t111;
import java.util.LinkedList;

public class minDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        int depth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (null != root) {queue.add(root);}else return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (null == temp.left && null == temp.right) return depth;
                if (null != temp.left) queue.add(temp.left);
                if (null != temp.right) queue.add(temp.right);

            }
            depth++;
        }
        return depth;
    }
    public static void main(String[] args) {
        minDepth m = new minDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(20);
        root.right.right  =  new TreeNode(20);
        System.out.println(m.minDepth(root));
    }
}
