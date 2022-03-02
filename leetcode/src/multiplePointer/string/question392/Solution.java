package multiplePointer.string.question392;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-02 10:30
 **/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int ps = 0;
        int pt = 0;
        if (null == s || null == t) {
            return false;
        }
        int lens = s.length();
        int lent = t.length();
        while (ps < lens && pt < lent) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        return ps == lens;
    }
}
