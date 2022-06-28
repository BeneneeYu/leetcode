package dfs.permutation.question131;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-25 15:13
 **/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> tmp, String s, int lastSplit) {
        if (lastSplit >= s.length()) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = lastSplit; i < s.length(); i++) {
                if (isPalindrome(s, lastSplit, i)) {
                    tmp.add(s.substring(lastSplit, i + 1));
                    backtrack(res, tmp, s, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
