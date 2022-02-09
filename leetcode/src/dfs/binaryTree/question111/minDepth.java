package dfs.binaryTree.question111;

import dfs.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {

    public int dfsMinDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        // try the left and right subtrees
        if (root.left != null) {
            min_depth = Math.min(dfsMinDepth1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(dfsMinDepth1(root.right), min_depth);
        }
        return min_depth + 1;
    }


    public int dfsMinDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的最小深度
        int left = dfsMinDepth2(root.left);
        // 计算右子树的最小深度
        int right = dfsMinDepth2(root.right);
        // 如果左子树或右子树的深度不为 0，即只存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    // in bfs, when we find a leaf node, since the properties of bfs, the depth of this not must be minimum
    public int bfsMinDepth(TreeNode root) {
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        if (null != root) {
            queue.add(root);
        } else return 0;
        // search by layer
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // to consume the nodes in layer depth
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
        root.right.right = new TreeNode(20);
        System.out.println(m.bfsMinDepth(root));
    }
}
