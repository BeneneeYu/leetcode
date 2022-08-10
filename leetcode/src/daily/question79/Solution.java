package daily.question79;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-10 16:11
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // check(i,j,k), starting from board[i][j], if we can find s[k...] in the grid
    // so, traverse all the grid(check(i,j,0), if true is returned, there exists)
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean result = false;
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (validPos(board, newI, newJ) && !visited[newI][newJ]) {
                if (check(board, visited, newI, newJ, s, k + 1)) {
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    private boolean validPos(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
