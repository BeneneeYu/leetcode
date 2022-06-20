package dfs.graph.question139;

import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-18 20:51
 **/
public class Solution {
    String str;
    List<String> dict;
    byte[] memo; // 0 undefined, 1 true, 2 false

    public boolean wordBreak(String s, List<String> wordDict) {
        str = s;
        dict = wordDict;
        memo = new byte[s.length()];
        return canBreak(0);
    }

    // if word can break from start to len(str)
    // call when str(0, start) can break, or the call is meaningless
    private boolean canBreak(int start) {
        int len = str.length();
        if (start == len) return true; // valid until the last char
        if (memo[start] != 0) return memo[start] == 1;
        for (int i = start + 1; i <= len; i++) {
            if (dict.contains(str.substring(start, i)) && canBreak(i)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 2;
        return false;
    }
}
