package dfs.backtrack.question51;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-30 22:01
 **/
public class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i]: in row i, queen is placed at column queens[i]
        Arrays.fill(queens, -1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backtrack(queens, n, 0, column, diag1, diag2);
        return result;
    }

    private void backtrack(int[] queens, int n, int row, Set<Integer> column, Set<Integer> diag1, Set<Integer> diag2) {
        if (n == row) {
            result.add(generateBoard(queens));
        } else {
            for (int i = 0; i < n; i++) {
                int d1 = i - row;
                int d2 = i + row;
                if (column.contains(i) || diag1.contains(d1) || diag2.contains(d2)) {
                    continue;
                }
                queens[row] = i;
                column.add(i);
                diag1.add(d1);
                diag2.add(d2);
                backtrack(queens, n, row + 1, column, diag1, diag2);
//                queens[row] = -1;
                column.remove(i);
                diag1.remove(d1);
                diag2.remove(d2);
            }
        }

    }

    private List<String> generateBoard(int[] queens) {
        List<String> aBoard = new ArrayList<>();
        int n = queens.length;
        for (int queen : queens) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(i == queen ? 'Q' : '.');
            }
            aBoard.add(sb.toString());
        }
        return aBoard;
    }
}
