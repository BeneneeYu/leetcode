package dynamicProgramming.others.question799;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-04 09:45
 **/
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[102][102];
        glasses[0][0] = (double) poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double q = (glasses[i][j] - 1.0) / 2.0;
                if (q > 0) {
                    glasses[i + 1][j] += q;
                    glasses[i + 1][j + 1] += q;
                }
            }
        }
        return Math.min(glasses[query_row][query_glass], 1.0);
    }
}
