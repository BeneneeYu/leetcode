package multiplePointer.preSum.question1074;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-18 09:46
 **/
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] preSumArea = new int[rows + 1][cols + 1]; // preSumArea[i][j] = square of (0, 0, i, j)
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                preSumArea[i][j] = preSumArea[i - 1][j] + preSumArea[i][j - 1] - preSumArea[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int top = 1; top <= rows; top++) {
            for (int bot = top; bot <= rows; bot++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>(); // Submatrices on the left side is stored
                for (int right = 1; right <= cols; right++) {
                    cur = preSumArea[bot][right] - preSumArea[top - 1][right];
                    if (cur == target) ans += 1;
                    if (map.containsKey(cur - target)) {
                        ans += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}
