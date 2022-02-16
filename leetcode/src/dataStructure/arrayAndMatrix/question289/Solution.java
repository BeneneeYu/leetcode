package dataStructure.arrayAndMatrix.question289;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-16 11:30
 **/
public class Solution {
    // composite state: -1 alive past dead now
    // 2 dead past alive now
    public void gameOfLife(int[][] board) {
        int[] neighbours = new int[]{0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbourAlive = 0;
                for (int i1 = 0; i1 < 3; i1++) {
                    for (int j1 = 0; j1 < 3; j1++) {
                        if (!(i1 == 0 && j1 == 0)) {
                            int r = (i + neighbours[i1]);
                            int c = (j + neighbours[j1]);
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (board[r][c] == 1 || board[r][c] == -1)) {
                                neighbourAlive += 1;
                            }
                        }
                    }
                }
                // in traversal, since every element is visited the first time, it can only be 0 or 1
                if (board[i][j] == 1) {
                    if (neighbourAlive < 2 || neighbourAlive > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (neighbourAlive == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        updateBoardByCompositeState(board);
    }

    private void updateBoardByCompositeState(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

}
