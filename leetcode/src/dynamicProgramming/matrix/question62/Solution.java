package dynamicProgramming.matrix.question62;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-23 14:53
 **/
public class Solution {
    // higher
    // path number from left-up corner
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    // high time efficiency
    // path to right-bottom corner
    private int[][] generatePossiblePathMatrix(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m - 1][n - 1] = 1;

        for (int curN = n - 1; curN >= 0; curN--) {
            for (int curM = m - 1; curM >= 0; curM--) {
                if (curM == m - 1 && curN == n - 1) continue;
                matrix[curM][curN] = matrix[curM + 1][curN] + matrix[curM][curN + 1];
            }
        }

        return matrix;
    }

    // low efficiency
    private int countPath(int m, int n, int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        } else if (row == m - 1) {
            return countPath(m, n, row, col + 1);
        } else if (col == n - 1) {
            return countPath(m, n, row + 1, col);
        } else {
            return countPath(m, n, row + 1, col) + countPath(m, n, row, col + 1);
        }
    }
}
