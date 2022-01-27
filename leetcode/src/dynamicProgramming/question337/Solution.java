package dynamicProgramming.question337;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-12-05 10:46
 **/
public class Solution {

    public int rob(TreeNode root) {
        if (null == root){
            return 0;
        }
        int[] values = dfs(root);
        return Math.max(values[0],values[1]);
    }

    //Any subtree with root t, to obtain the maximum sum of weight,
    // {maximum weight when t is selected, maximum weight when t is not selected}
    public int[] dfs(TreeNode t){
        if (null == t){
            return new int[]{0,0};
        }
        int[] l = dfs(t.left);
        int[] r = dfs(t.right);
        int weightSelectingT = t.val + l[1] + r[1];
        int weightNotSelectingT = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[]{weightSelectingT,weightNotSelectingT};
    }
}
