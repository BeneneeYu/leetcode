package bfs.matrix.question542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-01 21:55
 **/
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int thisRow = pos[0];
            int thisCol = pos[1];
            int thisDist = mat[thisRow][thisCol];
            for (int i = 0; i < 4; i++) {
                int newRow = thisRow + directionX[i];
                int newCol = thisCol + directionY[i];
                if (isValid(rows, cols, newRow, newCol) && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = thisDist + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }

    private boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
