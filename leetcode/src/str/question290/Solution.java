package str.question290;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-17 08:27
 **/
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] inputs = s.split(" ");
        char[] chars = pattern.toCharArray();
        int i = 0;
        int length = pattern.length();
        if (chars.length != inputs.length) return false;
        String[] words = new String[26];
        Set<String> wordSet = new HashSet<>();
        Arrays.fill(words,"");

        while (i < length) {
            if ("".equals(words[chars[i] - 'a'])) {
                if (wordSet.contains(inputs[i])){
                    return false;
                }
                words[chars[i] - 'a'] = inputs[i];
                wordSet.add(inputs[i]);
            } else {
                if (!inputs[i].equals(words[chars[i] - 'a'])) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPattern("e",
                "eukera"));
    }
}
