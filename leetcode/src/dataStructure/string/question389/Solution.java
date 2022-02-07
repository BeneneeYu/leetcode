package dataStructure.string.question389;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-07 08:41
 **/
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int res = 0;
        for (char c : sChar) {
            res += c;
        }
        for (char c : tChar) {
            res -= c;
        }
        return (char)(-res);
    }
}
