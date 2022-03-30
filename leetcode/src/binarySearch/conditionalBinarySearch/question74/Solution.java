package binarySearch.conditionalBinarySearch.question74;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-30 08:22
 **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[rows - 1][cols - 1] < target) return false;
        // binary search to define which row
        int lowRow = -1;
        int highRow = rows - 1;
        int baseRow = -1;
        while (lowRow < highRow) {
            int midRow = (highRow - lowRow + 1) / 2 + lowRow;
            if (matrix[midRow][0] <= target) {
                lowRow = midRow;
            } else {
                highRow = midRow - 1;
            }
        }
        baseRow = lowRow;
        if (baseRow < 0) {
            return false;
        }
        int lowCol = 0;
        int highCol = cols - 1;
        while (lowCol <= highCol) {
            int midCol = (highCol - lowCol) / 2 + lowCol;
            if (matrix[baseRow][midCol] == target) {
                return true;
            } else if (matrix[baseRow][midCol] < target) {
                lowCol = midCol + 1;
            } else {
                highCol = midCol - 1;
            }
        }
        return false;
    }

    // we can also append all the rows and do binary search once
}
