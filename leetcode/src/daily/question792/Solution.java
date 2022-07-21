package daily.question792;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description: Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * @author: Shen Zhengyu
 * @create: 2022-07-20 09:01
 **/
public class Solution {
    class Node {
        String s;
        int index;

        Node(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Node>[] heads = new ArrayList[26];
        int res = 0;
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }
        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        for (char c : s.toCharArray()) {
            ArrayList<Node> bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();
            for (Node node : bucket) {
                node.index += 1;
                if (node.index == node.s.length()) {
                    res += 1;
                }else{
                    heads[node.s.charAt(node.index) - 'a'].add(node);
                }
            }
        }
        return res;
    }
}
