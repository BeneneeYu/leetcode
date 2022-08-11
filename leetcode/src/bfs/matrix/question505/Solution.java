package bfs.matrix.question505;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-11 17:26
 **/
public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        int[][] distance = new int[maze.length][maze[0].length];
        // distance[i][j]: lowest distance from starting point
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[des[0]][des[1]] == Integer.MAX_VALUE ? -1 : distance[des[0]][des[1]];
    }

    private void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int curSteps = 0;
            int newX = start[0] + direction[0];
            int newY = start[1] + direction[1];
            while (isValidPos(newX, newY, maze.length, maze[0].length) && maze[newX][newY] == 0) {
                newX += direction[0];
                newY += direction[1];
                curSteps += 1;
            }
            newX -= direction[0];
            newY -= direction[1];
            if (distance[newX][newY] - distance[start[0]][start[1]] > curSteps) {
                distance[newX][newY] = distance[start[0]][start[1]] + curSteps;
                dfs(maze, new int[]{newX, newY}, distance);
            }
            // backtrack condition: this will be a farther route
            else{
                return;
            }
        }
    }

    private boolean isValidPos(int x, int y, int r, int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
