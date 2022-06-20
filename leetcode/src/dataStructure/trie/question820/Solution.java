package dataStructure.trie.question820;



import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-20 09:10
 **/
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        Map<Trie, Integer> map = new HashMap<>(); // a single word
        for (int i = 0; i < words.length; i++) {
            map.put(root.insert(reverseString(words[i])), i);
        }
        int res = 0;
        for (Trie trie : map.keySet()) {
            if (trie.count == 0) {
                res += words[map.get(trie)].length();
            }
        }
        return res;
    }

    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;
        public int count;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public Trie insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                node.count += 1;
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
            return node;
        }


    }

}
