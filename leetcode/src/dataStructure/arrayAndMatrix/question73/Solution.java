package dataStructure.arrayAndMatrix.question73;

/**
 * @program: leetcode
 * @description: Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's. (in-place)
 * @author: Shen Zhengyu
 * @create: 2022-02-15 22:14
 **/
public class Solution {
    // use the first row and column to set flags and two additional flag parameters
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                zeroInFirstCol = true;
                break;
            }
        }
        // the first row and col is just for make flags
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroInFirstRow) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (zeroInFirstCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
