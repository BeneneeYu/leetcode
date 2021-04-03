package dynamic.question1143;

/**
 * @program: leetcode
 * @description:给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Shen Zhengyu
 * @create: 2021-04-03 14:22
 **/

public class LongestPublicSubSequence {

    /*dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列的长度
    dp[0][x] = dp[y][0] = 0
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2){
                    //i-1和j-1位一样，是公共字符
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    //i-1和j-1不一样，那么择一删除，数目依旧一样，最长所以取更大的
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestPublicSubSequence l = new LongestPublicSubSequence();
        System.out.println(l.longestCommonSubsequence("abcde", "ace"));
    }
}
