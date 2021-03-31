package tree.t95;

import java.util.LinkedList;
import java.util.List;

public class allDifferentBinarySearchTree {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }
    public void showTrees(int n) {
         List<TreeNode> t = generateTrees(n);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode front;
        for (TreeNode r:
             t) {
//            queue.push(r);
//            while (!queue.isEmpty()){
//                front = queue.pop();
//
//                if (null != front.left){
//                    queue.push(front.left);
//                }
//                if (null != front.right){
//                    queue.push(front.right);
//                }
//                System.out.print(" "+ front.val);
//            }
            System.out.print((r==null?null:r.val) + " " + (r.left==null?null:r.left.val) + " " +  (r.right==null?null:r.right.val));

            System.out.println();
        };
    }
    public static void main(String[] args) {
        allDifferentBinarySearchTree allDifferentBinarySearchTree = new allDifferentBinarySearchTree();

        allDifferentBinarySearchTree.showTrees(3);
    }
}
