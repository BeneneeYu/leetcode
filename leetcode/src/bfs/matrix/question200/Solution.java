package bfs.matrix.question200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-08 21:12
 **/
public class Solution {
    public int bfsNumIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int nor = grid.length;
        int noc = grid[0].length;
        int count = 0;
        for (int r = 0; r < nor; r++) {
            for (int c = 0; c < noc; c++) {
                if ('1' == grid[r][c]) {
                    count += 1;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<Integer>();
                    neighbors.add(r * noc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / noc;
                        int col = id % noc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * noc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nor && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * noc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * noc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < noc && grid[row][col + 1] == '1') {
                            neighbors.add(row * noc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int nor = grid.length;
        int noc = grid[0].length;
        for (int i = 0; i < nor; i++) {
            for (int i1 = 0; i1 < noc; i1++) {
                if (grid[i][i1] == '1') {
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
