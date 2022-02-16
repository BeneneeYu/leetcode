package dataStructure.hash.question953;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * @author: Shen Zhengyu
 * @create: 2022-02-16 16:33
 **/
public class Solution {
    int[] relativeOrder = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            relativeOrder[chars[i] - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!(compare(words[i - 1], words[i]))) {
                return false;
            }
        }
        return true;
    }

    // if word1 is sorted lexicographically before word2, return true;
    private boolean compare(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            if (relativeOrder[(int) (word1.charAt(i) - 'a')] < relativeOrder[(int) (word2.charAt(i) - 'a')]) {
                return true;
            }else if (relativeOrder[(int) (word1.charAt(i) - 'a')] > relativeOrder[(int) (word2.charAt(i) - 'a')]){
                return false;
            }
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        s.isAlienSorted(words, order);
    }
}
