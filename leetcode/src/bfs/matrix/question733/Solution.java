package bfs.matrix.question733;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-02 14:18
 **/
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int[] directionRow = {-1, 1, 0, 0};
        int[] directionCol = {0, 0, -1, 1};
        int pixel = image[sr][sc];
        if (pixel == newColor) return image; // or the program can not detect if a cell is visited
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = pos[0] + directionRow[i];
                int newCol = pos[1] + directionCol[i];
                if (isValid(rows, cols, newRow, newCol) && image[newRow][newCol] == pixel) {
                    queue.offer(new int[]{newRow, newCol});
                    image[newRow][newCol] = newColor; // so that we can avoid duplicate visiting
                }
            }
        }
        return image;
    }

    private boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
