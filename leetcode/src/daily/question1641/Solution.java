package daily.question1641;

/**
 * @program: Leetcode
 * @description: Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 * @author: Shen Zhengyu
 * @create: 2022-05-11 13:04
 **/
public class Solution {
    public int countVowelStrings(int n) {
        // for n digits, if the first character is a, then the left n-1 digits can be all the situations
        // if the first character is i, then the left n-1 digits can only start with i,o,u
        int res = 0;
        int dp[] = new int[]{1,1,1,1,1}; // n = 1
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            // every iteration we figure out number of strings with five different characters starting
            for (int j = 4; j > 0; j--){
                sum += dp[j];
                dp[j] = sum;
            }
        }
        for(int i : dp){
            res += i;
        }
        return res;
    }
}
