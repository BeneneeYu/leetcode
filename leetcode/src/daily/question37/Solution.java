package daily.question37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-06 09:13
 **/
public class Solution {
    boolean[][] row = new boolean[9][9]; // row[i][j]: in row i, num j + 1 is used
    boolean[][] col = new boolean[9][9];
    boolean[][] block = new boolean[9][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) { // row i
            for (int j = 0; j < 9; j++) { // column j
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3; // which sub-box
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blockIndex][num] = true;
                } else {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
        for (boolean[] booleans : row) {
            System.out.println(Arrays.toString(booleans));
        }
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        // If correct solution has been constructed, there should be no modifications
        for (int candidate = 1; candidate <= 9 && !valid; candidate++) {
            int blockIndex = i / 3 * 3 + j / 3;
            int num = candidate - 1;
            if (!(row[i][num] || col[j][num] || block[blockIndex][num])) {
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                dfs(board, pos + 1);
                row[i][num] = false;
                col[j][num] = false;
                block[blockIndex][num] = false;
            }
        }
    }
}
