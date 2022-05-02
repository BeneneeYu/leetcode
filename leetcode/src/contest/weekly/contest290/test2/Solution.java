package contest.weekly.contest290.test2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-23 21:36
 **/
public class Solution {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int rows = matrix.length, columns = matrix[0].length();
        int[][] distances = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        distances[start[0]][start[1]] = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            char c = matrix[row].charAt(column);
            int directionIndex = getDirectionIndex(c);
            for (int i = 0; i < 4; i++) {
                int increase = i == directionIndex ? 0 : 1;
                int newDistance = distances[row][column] + increase;
                int newRow = row + directions[i][0], newColumn = column + directions[i][1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (newDistance < distances[newRow][newColumn]) {
                        distances[newRow][newColumn] = newDistance;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        return distances[end[0]][end[1]];
    }

    public int getDirectionIndex(char c) {
        if (c == '^')
            return 0;
        else if (c == 'v')
            return 1;
        else if (c == '<')
            return 2;
        else if (c == '>')
            return 3;
        return -1;
    }
}
