package dynamicProgramming.singleSequence.question139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordSplit {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("and");
        System.out.println(wordBreak("catsanddog",list));
        double result = Math.sin(Math.PI/9)* Math.sin(Math.PI/6)* Math.sin(Math.PI/6);
        System.out.println(result);
        double result1 = Math.sin(Math.PI/18)* Math.sin(2* Math.PI/9)* Math.sin(5* Math.PI/18);
        System.out.println(result1-result);
    }
}
