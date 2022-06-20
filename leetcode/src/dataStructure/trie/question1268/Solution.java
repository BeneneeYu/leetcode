package dataStructure.trie.question1268;

import dataStructure.trie.question208.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-19 11:34
 **/
public class Solution {
    List<String> singleRes;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product : products) {
            root.insert(product);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            singleRes = new ArrayList<>();
            Trie node = root.searchPrefix(prefix);
            if (null != node) {
                if (node.isEnd()) singleRes.add(prefix);
                getStrings(node, prefix);
            }
            res.add(singleRes);
        }
        return res;
    }

    private void getStrings(Trie node, String pre) {
        Trie[] children = node.getChildren();
        for (int j = 0; j < children.length; j++) {
            Trie child = children[j];
            dfs(child, pre + (char) ('a' + j));
        }
    }

    private void dfs(Trie node, String s) {
        if (singleRes.size() >= 3 || null == node) return;
        if (node.isEnd()) {
            singleRes.add(s);
        }
        Trie[] children = node.getChildren();
        for (int i = 0; i < children.length; i++) {
            Trie child = children[i];
            if (child != null) {
                char c = (char) ('a' + i);
                dfs(child, s + c);
            }
        }
    }
}
