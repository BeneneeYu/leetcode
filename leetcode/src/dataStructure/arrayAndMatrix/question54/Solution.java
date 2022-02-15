package dataStructure.arrayAndMatrix.question54;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: Given an m x n matrix, return all elements of the matrix in spiral order.
 * @author: Shen Zhengyu
 * @create: 2022-02-15 21:03
 **/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0) return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int eleNum = rows * cols;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        while (eleNum > 0) {
            // eleNum > 0 in for loop to handle rectangle
            for (int i = left; i <= right && eleNum > 0; i++) {
                result.add(matrix[top][i]);
                eleNum--;
            }
            top++;
            for (int i = top; i <= bottom && eleNum > 0; i++) {
                result.add(matrix[i][right]);
                eleNum--;
            }
            right--;
            for (int i = right; i >= left && eleNum > 0; i--) {
                result.add(matrix[bottom][i]);
                eleNum--;
            }
            bottom--;
            for (int i = bottom; i >= top && eleNum > 0; i--) {
                result.add(matrix[i][left]);
                eleNum--;
            }
            left++;
        }
        return result;
    }
}
