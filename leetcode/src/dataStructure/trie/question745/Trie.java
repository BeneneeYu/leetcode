package dataStructure.trie.question745;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-18 10:06
 **/
public class Trie {
    public Trie[] children;
    public int weight;
    public Trie(){
        children = new Trie[27];
        weight = 0;
    }
}
