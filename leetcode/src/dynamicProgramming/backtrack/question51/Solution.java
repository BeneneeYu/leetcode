package dynamicProgramming.backtrack.question51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();//存放摆放方案
        int[] queens = new int[n];//代表目前皇后摆放情况
        Arrays.fill(queens, -1);//先是每行都没确定摆放位置
        Set<Integer> columns = new HashSet<Integer>();//列的摆放信息
        Set<Integer> diagonals1 = new HashSet<Integer>();//左上对角线，行列下标之差相同
        Set<Integer> diagonals2 = new HashSet<Integer>();//右上对角线，行列下标之和相同
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {//摆放选择已经到了棋盘外，说明棋盘内已经摆好
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //处理row行的情况
            //遍历每一列i
            for (int i = 0; i < n; i++) {
                //如果列/左右对角线被使用，下一列
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                //在row行放在i列上
                queens[row] = i;
                //使用对角线、列
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //向下继续回溯
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                //因为要尝试其它的可能，所以要用base情况走完for循环，否则不能统计所有的情况
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
