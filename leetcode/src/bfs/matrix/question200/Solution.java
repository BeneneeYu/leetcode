package bfs.matrix.question200;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-08 21:12
 **/
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int nor = grid.length;
        int noc = grid[0].length;
        for (int i = 0; i < nor; i++) {
            for (int i1 = 0; i1 < noc; i1++) {
                if (grid[i][i1] == '1'){
                    count++;
                    dfs(grid, i, i1);
                }
            }
        }
        return count;
    }

    //dfs
    void dfs(char[][] grid, int r, int c) {
        int nor = grid.length;
        int noc = grid[0].length;

        // reach the bound
        if (r < 0 || r >= nor || c < 0 || c >= noc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0'; // or may cause dead lock / count duplicated islands
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
