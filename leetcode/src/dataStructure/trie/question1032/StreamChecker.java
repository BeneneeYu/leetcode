package dataStructure.trie.question1032;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-12-04 20:32
 **/
public class StreamChecker {
    HashSet<String> wordSet;
    int index = 0;
    int queryLength = 40000;
    String[] strings = new String[queryLength + 1];
    ArrayList<Character> charList;
    int maxLength;
    public StreamChecker(String[] words) {
        wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
            maxLength = Math.max(word.length(),maxLength);
        }
        charList = new ArrayList<>();
        strings[queryLength] = "";
        System.out.println(maxLength);
    }

    public boolean query(char letter) {
        index++;
        for (int i = index; i > 0; i--) {
            if (null == strings[queryLength-i+1] || strings[queryLength - i + 1].length() > maxLength){
                continue;
            }
            strings[queryLength - i] = strings[queryLength - i + 1] + letter;
        }
        for (String s : wordSet) {
            if (s.equals(strings[queryLength-s.length()])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        StreamChecker sc = new StreamChecker(new String[]{"cd","f","kl"});
        System.out.println(sc.query('a'));
        System.out.println(sc.query('b'));
        System.out.println(sc.query('c'));
        System.out.println(sc.query('d'));
        System.out.println(sc.query('e'));
        System.out.println(sc.query('f'));
        System.out.println(sc.query('g'));
        System.out.println(sc.query('h'));
        System.out.println(sc.query('i'));
        System.out.println(sc.query('j'));
        System.out.println(sc.query('k'));
        System.out.println(sc.query('l'));

    }
}