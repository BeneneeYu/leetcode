package dfs.permutation.question17;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-09 11:45
 **/
public class Solution {
    private static final String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits)) return result;
        dfs(digits, 0, new StringBuilder());
        return result;
    }
    private void dfs(String digits, int index, StringBuilder sb){
        if (index == digits.length()){
            result.add(sb.toString());
            return;
        }
        String potential = strings[digits.charAt(index) - '0'];
        for (int i = 0; i < potential.length(); i++) {
            char c = potential.charAt(i);
            StringBuilder newSb = new StringBuilder(sb.toString());
            newSb.append(c);
            dfs(digits, index + 1, newSb);
        }
    }
}
