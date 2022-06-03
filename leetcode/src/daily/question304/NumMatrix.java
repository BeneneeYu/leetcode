package daily.question304;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-03 10:35
 **/
class NumMatrix {

    private int[][] dpRow;
    private int[][] dpRec;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dpRow = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dpRow[i][j + 1] = dpRow[i][j] + matrix[i][j];
            }
        }
        dpRec = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dpRec[i + 1][j + 1] = matrix[i][j] + dpRec[i + 1][j] + dpRec[i][j + 1] - dpRec[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += (dpRow[i][col2 + 1] - dpRow[i][col1]);
        }
        return sum;
    }

    public int sumRegionRec(int row1, int col1, int row2, int col2) {
        return dpRec[row1][col1] - dpRec[row2 + 1][col1] - dpRec[row1][col2 + 1] + dpRec[row2 + 1][col2 + 1];
    }
}
