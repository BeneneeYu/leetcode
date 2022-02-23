package dataStructure.monotonicStack.question85;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * @author: Shen Zhengyu
 * @create: 2022-02-23 19:27
 **/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ret = 0;
        // for every column
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new LinkedList<Integer>();
            // the top row that can't be reached
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            System.out.println("j:up " + j + " " + Arrays.toString(up));

            stack.clear();
            // the bottom row that can't be reached
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            System.out.println("j:down " + j + " " + Arrays.toString(down));

            // for every row
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                System.out.println("for (" + i + "," + j + "), left[i][j] = " + left[i][j] + ", down[i] = " + down[i] + ", up[i] = " + up[i]);
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] data = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        s.maximalRectangle(data);
    }
}
