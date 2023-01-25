package daily.question909;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.com/problems/snakes-and-ladders/description/
public class Solution {
    int rows;
    int cols;

    int[][] board;
    public int snakesAndLadders(int[][] _board) {
        // start from left-down corner
        board = _board;
        rows = board.length;
        cols = board[0].length;

        int curr = 1;
        int des = rows * cols;
        boolean[] visited = new boolean[des + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.add(curr);
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps += 1;
            for (int j = 0; j < size; j++) {
                curr = queue.poll();
                if (curr == des) return steps;
                for (int i = 1; i <= 6; i++) {
                    int nxt = curr + i;
                    if (nxt > des) break;
                    int[] pos = getPosByIndex(nxt);
                    if (board[pos[0]][pos[1]] != -1) {
                        nxt = board[pos[0]][pos[1]];
                    }
                    if (nxt == des) return steps;
                    // cannot cut branches here because the last grid may lead to costing way
                    // if (board[pos[0]][pos[1]] == -1 && i < 6) continue;
                    if (!visited[nxt]) {
                        queue.offer(nxt);
                        visited[nxt] = true;
                    }
                }
            }
        }
        return -1;
    }



    private int[] getPosByIndex(int index) {
        int row = rows - ((index - 1) / cols) - 1;
        int col = (rows - row - 1) % 2 == 0 ? (index - (rows - row - 1) * cols - 1) : (cols - (index - (rows - row - 1) * cols));
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        System.out.println(s.snakesAndLadders(board));
    }
}
