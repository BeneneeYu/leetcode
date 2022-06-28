package dynamicProgramming.matrix.question363;

import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE; // as large as possible, but <= k
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int tb = 0; tb < rows; tb++) { // try every top border
            int[] sum = new int[cols]; // sum from column top
            for (int bb = tb; bb < rows; bb++) { // try every bottom border
                for (int j = 0; j < cols; j++) {
                    sum[j] += matrix[bb][j]; // incremental sum of every column from tb to bb
                }
                //Sr - Sl <= k, Sl >= Sr - k, Sr - Sl to be bigger, Sl should be small but bigger than Sr - k
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0); // store the area of rectangle [0,r] [tb, bb]
                // sum of rectangle, Sr
                int s = 0;
                for (int v : sum) {
                    s += v;
                    // find the bigger Sl, which >= Sr - k
                    Integer ceil = sumSet.ceiling(s - k); // return element >= argument, or null
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    // become a new Sl
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
