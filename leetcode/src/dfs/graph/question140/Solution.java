package dfs.graph.question140;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-18 17:02
 **/
public class Solution {
    String s;
    Map<Integer, List<String>> memo = new HashMap<>();
    Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        dict = new HashSet<>(wordDict); // convert list to set
        return dfs(0); // dfs from the head
    }

    List<String> dfs(int start) {
        // memorize the result of dfs(start)
        if (memo.containsKey(start)) return memo.get(start);
        if (start >= s.length()) {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add("");
            return tmp;
        }
        // result of this call, all the possible splitting results
        List<String> ret = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) {
            // examine all the possible split
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                // a valid split, continue to try splitting
                List<String> last = dfs(i);
                // use the result of sub problem
                for (String l : last) {
                    ret.add(!l.equals("") ? sub + " " + l : sub);
                }
            }
        }
        memo.put(start, ret);
        return ret;
    }
}
