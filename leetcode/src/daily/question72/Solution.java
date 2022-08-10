package daily.question72;

/**
 * @program: Leetcode
 * @description: Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * @author: Shen Zhengyu
 * @create: 2022-08-10 15:54
 **/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        // D[i][j]: the edit distance between the first i chars of word1
        // and the first j chars of word2
        int[][] D = new int[n + 1][m + 1];

        // since one word is null, the edit distance is the length of the other word
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1; // no more than
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                // not the same ending char, extra step
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                // left, down, left_down
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
