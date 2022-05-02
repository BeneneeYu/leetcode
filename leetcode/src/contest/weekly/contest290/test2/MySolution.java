package contest.weekly.contest290.test2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-23 15:10
 **/
public class MySolution {
    boolean[][] visited;
    int minTimes;
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int rows = matrix.length;
        int cols = matrix[0].length();
        int startRow = start[0];
        int startCol = start[1];
        int endRow = end[0];
        int endCol = end[1];
        visited = new boolean[rows][cols];
        minTimes = Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
        int[][] dp = new int[rows][cols]; // min times to get [i,j] from start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[startRow][startCol] = 0;
        dp(matrix, dp, startRow, startCol, visited, endRow, endCol);
        return dp[endRow][endCol];
    }

    private void dp(String[] matrix, int[][] dp, int row, int col, boolean[][] visited, int endRow, int endCol) {
        if (row == endRow && col == endCol){
            minTimes = Math.min(minTimes, dp[endRow][endCol]);
            return;
        }
        if (dp[row][col] >= minTimes) return;
        char direction = matrix[row].charAt(col);
        int currentVal = dp[row][col];
        int upVal = currentVal + 1;
        int downVal = currentVal + 1;
        int leftVal = currentVal + 1;
        int rightVal = currentVal + 1;
        switch (direction) {
            case '>':
                rightVal--;
                break;
            case '^':
                upVal--;
                break;
            case '<':
                leftVal--;
                break;
            case 'v':
                downVal--;
                break;
            default:
                break;
        }
//        System.out.println("now I am in " + row + "," + col + " and dp" + (row) + "," + col + " now is " + dp[row][col]);
        visited[row][col] = true;
        if (isInMatrix(matrix, row - 1, col) && !visited[row - 1][col]) {
            dp[row - 1][col] = Math.min(dp[row - 1][col], upVal);
//            System.out.println("dp" + (row-1) + "," + col + " now is" + dp[row-1][col]);
            dp(matrix, dp, row - 1, col, copyArray(visited), endRow, endCol);
        }
        if (isInMatrix(matrix, row + 1, col) && !visited[row + 1][col]) {
            dp[row + 1][col] = Math.min(dp[row + 1][col], downVal);
//            System.out.println("dp" + (row + 1) + "," + col + " now is" + dp[row + 1][col]);
            dp(matrix, dp, row + 1, col, copyArray(visited), endRow, endCol);
        }
        if (isInMatrix(matrix, row, col - 1) && !visited[row][col - 1]) {
            dp[row][col - 1] = Math.min(dp[row][col - 1], leftVal);
//            System.out.println("dp" + row + "," + (col-1) + " now is" + dp[row][col-1]);
            dp(matrix, dp, row, col - 1, copyArray(visited), endRow, endCol);
        }
        if (isInMatrix(matrix, row, col + 1) && !visited[row][col + 1]) {
            dp[row][col + 1] = Math.min(dp[row][col + 1], rightVal);
//            System.out.println("dp" + row + "," + (col+1) + " now is" + dp[row][col+1]);
            dp(matrix, dp, row, col + 1, copyArray(visited), endRow, endCol);
        }
    }


    private boolean[][] copyArray(boolean[][] originalArray){
        int col = originalArray[0].length;
        boolean[][] tmp = new boolean[originalArray.length][col];
        for (int i = 0; i < tmp.length; i++) {
            System.arraycopy(originalArray[i], 0, tmp[i], 0, col);
        }
        return tmp;
    }
    private boolean isInMatrix(String[] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length();
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        MySolution s = new MySolution();
        String[] matrix = {">>v", "v^<", "<><"};
        System.out.println(1 == s.conveyorBelt(matrix, new int[]{0, 1}, new int[]{2, 0}));
        String[] matrix1 = {">>v",">>v","^<<"};
        System.out.println(0 == s.conveyorBelt(matrix1, new int[]{0, 0}, new int[]{1, 1}));
        String[] matrix2 = {">^^>","<^v>","^v^<"};
        System.out.println(3 == s.conveyorBelt(matrix2, new int[]{0, 0}, new int[]{1, 3}));
    }
}
