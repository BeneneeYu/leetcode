package dataStructure.arrayAndMatrix.question59;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-13 09:05
 **/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int center = n * n;
        int count = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (count <= center){
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top += 1;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right -= 1;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count++;
            }
            bottom -= 1;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left += 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int[] ints : s.generateMatrix(3)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
