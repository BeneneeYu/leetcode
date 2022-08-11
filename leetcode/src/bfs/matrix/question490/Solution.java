package bfs.matrix.question490;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-11 13:48
 **/
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (destination[0] == start[0] && destination[1] == start[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        int r = start[1] + 1;
        int l = start[1] - 1;
        int u = start[0] - 1;
        int d = start[0] + 1;
        // rush right
        while (r < maze[0].length && maze[start[0]][r] == 0) {
            r += 1;
        }
        // when while loop break, last r is the last valid position
        if (dfs(maze, new int[]{start[0], r - 1}, destination, visited)) {
            return true;
        }

        while (l >= 0 && maze[start[0]][l] == 0) {
            l -= 1;
        }
        if (dfs(maze, new int[]{start[0], l + 1}, destination, visited)) {
            return true;
        }
        while (u >= 0 && maze[u][start[1]] == 0) {
            u -= 1;
        }
        if (dfs(maze, new int[]{u + 1, start[1]}, destination, visited)) {
            return true;
        }
        while (d < maze.length && maze[d][start[1]] == 0) {
            d += 1;
        }
        if (dfs(maze, new int[]{d - 1, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }

    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int newX = s[0] + direction[0];
                int newY = s[1] + direction[1];
                while (newX < maze.length && newX >= 0 && newY < maze[0].length && newY >= 0 && maze[newX][newY] == 0) {
                    newX += direction[0];
                    newY += direction[1];
                }
                if (!visited[newX - direction[0]][newY - direction[1]]) {
                    queue.add(new int[]{newX - direction[0], newY - direction[1]});
                    visited[newX - direction[0]][newY - direction[1]] = true;
                }
            }
        }
        return false;
    }
}
