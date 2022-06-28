package dataStructure.unionFind.question200;

import dataStructure.unionFind.UnionFind;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-28 14:58
 **/
public class Solution {
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind();
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    uf.add(r * nc + c);
                }
            }
        }
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.merge(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.merge(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.merge(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.merge(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getNumOfSet();
    }
}
