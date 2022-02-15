package dataStructure.arrayAndMatrix.question48;

/**
 * @program: leetcode
 * @description: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise) (in-place).
 * @author: Shen Zhengyu
 * @create: 2022-02-15 14:31
 **/
public class Solution {
    // key : matrix-new[col][n−row−1]=matrix[row][col]
    // transpose(Diagonal symmetry) and flip vertically
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 1) return;
        transpose(matrix);
        flipVer(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void flipVer(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n / 2); j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}
