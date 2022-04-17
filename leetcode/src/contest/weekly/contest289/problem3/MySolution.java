package contest.weekly.contest289.problem3;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-17 10:28
 **/
public class MySolution {
    public int maxTrailingZeros(int[][] grid) {
        // maximum tailing zeros num
        int rows = grid.length;
        int cols = grid[0].length;
        // no need to divide into four situations!
        // grids h and grids z is enough, subtraction is done in different directions
        String[][] left2Right = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            int num2 = 0;
            int num5 = 0;
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                // use customized class: Pair
                int val = grid[i][j];
                while (val % 5 == 0) {
                    num5 += 1;
                    val /= 5;
                }
                sb.append(num5).append(",");
                while (val % 2 == 0) {
                    num2 += 1;
                    val /= 2;
                }
                sb.append(num2);
                left2Right[i][j] = sb.toString();
            }
        }
        String[][] right2Left = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            int num2 = 0;
            int num5 = 0;
            for (int j = cols - 1; j >= 0; j--) {
                StringBuilder sb = new StringBuilder();
                int val = grid[i][j];
                while (val % 5 == 0) {
                    num5 += 1;
                    val /= 5;
                }
                sb.append(num5).append(",");
                while (val % 2 == 0) {
                    num2 += 1;
                    val /= 2;
                }
                sb.append(num2);
                right2Left[i][j] = sb.toString();
            }
        }
        String[][] bottom2Top = new String[rows][cols];
        for (int j = 0; j < cols; j++) {
            int num2 = 0;
            int num5 = 0;
            for (int i = rows - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                int val = grid[i][j];
                while (val % 5 == 0) {
                    num5 += 1;
                    val /= 5;
                }
                sb.append(num5).append(",");
                while (val % 2 == 0) {
                    num2 += 1;
                    val /= 2;
                }
                sb.append(num2);
                bottom2Top[i][j] = sb.toString();
            }
        }
        String[][] top2Bottom = new String[rows][cols];
        for (int j = 0; j < cols; j++) {
            int num2 = 0;
            int num5 = 0;
            for (int i = 0; i < rows; i++) {
                StringBuilder sb = new StringBuilder();
                int val = grid[i][j];
                while (val % 5 == 0) {
                    num5 += 1;
                    val /= 5;
                }
                sb.append(num5).append(",");
                while (val % 2 == 0) {
                    num2 += 1;
                    val /= 2;
                }
                sb.append(num2);
                top2Bottom[i][j] = sb.toString();
            }
        }
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];
                int self5 = 0;
                int self2 = 0;
                while (val % 5 == 0) {
                    self5 += 1;
                    val /= 5;
                }
                while (val % 2 == 0) {
                    self2 += 1;
                    val /= 2;
                }

                int num5 = 0;
                int num2 = 0;
                String[] tmp = left2Right[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                tmp = bottom2Top[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                result = Math.max(result, Math.min(num5 - self5, num2 - self2));
                num5 = 0;
                num2 = 0;
                tmp = right2Left[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                tmp = top2Bottom[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                result = Math.max(result, Math.min(num5 - self5, num2 - self2));
                num5 = 0;
                num2 = 0;
                tmp = left2Right[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                tmp = top2Bottom[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                result = Math.max(result, Math.min(num5 - self5, num2 - self2));
                num5 = 0;
                num2 = 0;
                tmp = right2Left[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                tmp = bottom2Top[i][j].split(",");
                num5 += Integer.parseInt(tmp[0]);
                num2 += Integer.parseInt(tmp[1]);
                result = Math.max(result, Math.min(num5 - self5, num2 - self2));
            }
        }
        return result;
    }
}
