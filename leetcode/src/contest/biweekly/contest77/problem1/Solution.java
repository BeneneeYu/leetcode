package contest.biweekly.contest77.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-30 22:29
 **/
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word : words) {
            if (s.length() >= word.length() && s.substring(0, word.length()).equals(word)){
                cnt += 1;
            }
        }
        return cnt;
    }
}
