package dfs.permutation.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-24 19:58
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (close > open || open > max) return;
        if (open == close && close == max) {
            res.add(cur.toString());
            return;
        }
        if (open < max) {
            backtrack(res, cur.append("("), open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            backtrack(res, cur.append(")"), open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> generateParenthesisDP(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        list0.add("");
        result.add(list0);
        List<String> list1 = new ArrayList<>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            List<String> thisResult = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> strList1 = result.get(j);
                List<String> strList2 = result.get(i - j - 1);
                for (String s : strList1) {
                    StringBuilder sb = new StringBuilder("(");
                    sb.append(s).append(")");
                    for (String s2 : strList2) {
                        thisResult.add(sb.toString() + s2);
                    }
                }
            }
            result.add(thisResult);
        }
        return result.get(n);
    }
}
