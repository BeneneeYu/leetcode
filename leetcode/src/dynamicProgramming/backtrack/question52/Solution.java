package dynamicProgramming.backtrack.question52;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  int count = 0;
  public int totalNQueens(int n) {
    int[] queens = new int[n];//代表目前皇后摆放情况
    Arrays.fill(queens, -1);//先是每行都没确定摆放位置
    Set<Integer> columns = new HashSet<Integer>();//列的摆放信息
    Set<Integer> diagonals1 = new HashSet<Integer>();//左上对角线，行列下标之差相同
    Set<Integer> diagonals2 = new HashSet<Integer>();//右上对角线，行列下标之和相同
    backtrack(queens, n, 0, columns, diagonals1, diagonals2);
    return count;
  }

  private void backtrack(int[] queens, int n, int i, Set<Integer> columns, Set<Integer> diagonals1,
      Set<Integer> diagonals2) {
    if(i == n){
      count++;
    }else{
      for (int j = 0; j < n; j++) {
        if (columns.contains(j)){
          continue;
        }
        int dia1 = i - j;
        if(diagonals1.contains(dia1)){
          continue;
        }
        int dia2 = i + j;
        if (diagonals2.contains(dia2)){
          continue;
        }
        queens[i] = j;
        columns.add(j);
        diagonals1.add(dia1);
        diagonals2.add(dia2);
        backtrack(queens,n,i+1,columns,diagonals1,diagonals2);
        queens[i] = -1;
        diagonals1.remove(dia1);
        diagonals2.remove(dia2);
        columns.remove(j);
      }
    }
  }

  public static void main(String[] args) {
    Solution solution1 = new Solution();
    System.out.println(solution1.totalNQueens(4));
    Solution solution2 = new Solution();
    System.out.println(solution2.totalNQueens(8));
  }
}
