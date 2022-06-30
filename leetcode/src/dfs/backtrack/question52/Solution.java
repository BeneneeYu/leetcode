package dfs.backtrack.question52;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-30 22:21
 **/
public class Solution {
    int cnt;

    public int totalNQueens(int n) {
        cnt = 0;
        Set<Integer> column = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backtrack(n, 0, column, diag1, diag2);
        return cnt;
    }

    private void backtrack(int n, int row, Set<Integer> column, Set<Integer> diag1, Set<Integer> diag2) {
        if (n == row) {
            cnt += 1;
        } else {
            for (int i = 0; i < n; i++) {
                int d1 = i - row;
                int d2 = i + row;
                if (column.contains(i) || diag1.contains(d1) || diag2.contains(d2)) {
                    continue;
                }
                column.add(i);
                diag1.add(d1);
                diag2.add(d2);
                backtrack(n, row + 1, column, diag1, diag2);
                column.remove(i);
                diag1.remove(d1);
                diag2.remove(d2);
            }
        }
    }
}
