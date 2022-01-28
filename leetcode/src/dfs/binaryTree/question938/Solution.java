package dfs.binaryTree.question938;

public class Solution {
  public int rangeSumBST(TreeNode root, int low, int high) {
    int sum = 0;
    if (low <= root.val && root.val <= high){
      sum += root.val;
    }
    if (null != root.left){
      sum += rangeSumBST(root.left,low,high);
    }
    if (null != root.right){
      sum += rangeSumBST(root.right,low,high);
    }
    return sum;
  }
  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(10);
    TreeNode treeNode2 = new TreeNode(5);
    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(3);
    TreeNode treeNode5 = new TreeNode(7);
    TreeNode treeNode6 = new TreeNode(18);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode3.right = treeNode6;
    Solution s = new Solution();
    System.out.println(s.rangeSumBST(treeNode1,7,15));
  }

}
