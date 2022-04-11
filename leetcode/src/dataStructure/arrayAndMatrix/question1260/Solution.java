package dataStructure.arrayAndMatrix.question1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * @author: Shen Zhengyu
 * @create: 2022-04-11 08:51
 **/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int start = m * n - k % (m * n); // new start
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i < m * n + start; ++i) { // adjust all the grid
            int j = i % (m * n);// steps away from the origin
            int r = j / n; // get the new row
            int c = j % n; // get the new col
            if ((i - start) % n == 0) {
                ans.add(new ArrayList<>());
            }
            ans.peekLast().add(grid[r][c]); // since the grid is added to the ans one by one
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] row1 = {1, 2, 3};
        int[] row2 = {4, 5, 6};
        int[] row3 = {7, 8, 9};
        int[][] grid = {row1, row2, row3};
        s.shiftGrid(grid, 1);
    }
}
