package contest.weekly.contest299.problem3;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-26 10:28
 **/
public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        if (len <= 0) return false;
        if (len == 1) return !(grid[0][0] == 0);
        for (int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++){
                if (inDiagonals(len, i, j)){
                    if (grid[i][j] == 0) return false;
                }else{
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }

    private boolean inDiagonals(int length, int x, int y){
        return (x == y) || (x + y == length - 1);
    }
}
