package bfs.matrix.question1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description: Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 * @author: Shen Zhengyu
 * @create: 2022-05-16 10:47
 **/
public class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int dis = 1;
            if (grid[0][0] != 0){
                return -1;
            }
            if (m == 1){
                return 1;
            }
            queue.offer(new int[]{0,0});
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int c = 0; c < size; ++c) {
                    int[] poll = queue.poll();
                    int i = poll[0];
                    int j = poll[1];
                    for (int k = 0; k < 8; ++k) {
                        int ni = i + dir[k][0];
                        int nj = j + dir[k][1];
                        int[] newPos = new int[]{ni, nj};
                        if (isValid(m, n, newPos) && grid[ni][nj] == 0) {
                            if (ni == m - 1 && nj == n - 1) {
                                return dis + 1;
                            }
                            queue.offer(new int[]{ni, nj});
                            grid[ni][nj] = 1;
                        }
                    }
                }
                //这一圈都加1
                dis += 1;
            }
            return -1;
    }


    private boolean isValid(int gridRows, int gridCols, int[] pos) {
        return pos[0] <= gridRows - 1 && pos[0] >= 0 && pos[1] <= gridCols - 1 && pos[1] >= 0;
    }
}
