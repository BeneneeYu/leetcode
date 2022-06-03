package bfs.matrix.question994;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-02 17:33
 **/
public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int orangeCount = 0;
        int rottenCount = 0;
        int time = 0;
        // multiple source
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    orangeCount += 1;
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                        rottenCount += 1;
                    }
                }
            }
        }
        if (rottenCount == orangeCount) return 0;
        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};
        // There may be a situation that all the oranges are rotten, but the queue is not empty.
        while (!queue.isEmpty() && orangeCount > rottenCount) {
            // time things
            time += 1;
            int batchCount = queue.size();
            for (int i = 0; i < batchCount; i++) {
                int[] rottenPos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = rottenPos[0] + directionX[j];
                    int nextY = rottenPos[1] + directionY[j];
                    if (isValid(rows, cols, nextX, nextY) && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        rottenCount += 1;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        if (rottenCount == orangeCount) {
            return time;
        } else {
            return -1;
        }
    }

    private boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
