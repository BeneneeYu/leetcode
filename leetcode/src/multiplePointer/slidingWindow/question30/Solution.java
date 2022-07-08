package multiplePointer.slidingWindow.question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-06 10:51
 **/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length; // num of words
        int n = words[0].length(); // length of a word
        int length = s.length(); // length of target string
        // cut the prev [0...n-1]
        // If necessary, cut the last [0...n-1]
        for (int i = 0; i < n; i++) {
            if (i + m * n > length) {
                break;
            }
            Map<String, Integer> occurrenceDiffer = new HashMap<>();
            // add the first m words
            for (int j = 0; j < m; j++) {
                String aWord = s.substring(i + j * n, i + (j + 1) * n);
                occurrenceDiffer.put(aWord, occurrenceDiffer.getOrDefault(aWord, 0) + 1);
            }
            // cut all the words in array word
            for (String word : words) {
                occurrenceDiffer.put(word, occurrenceDiffer.getOrDefault(word, 0) - 1);
                if (occurrenceDiffer.get(word) == 0) {
                    occurrenceDiffer.remove(word);
                }
            }
            // start with different word, slide the window
            for (int start = i; start < length - m * n + 1; start += n) {
                // skip the first comparison
                if (start != i) {
                    // put the newly added word in tail
                    String offset = s.substring(start + (m - 1) * n, start + m * n);
                    occurrenceDiffer.put(offset, occurrenceDiffer.getOrDefault(offset, 0) + 1);
                    if (occurrenceDiffer.get(offset) == 0) {
                        occurrenceDiffer.remove(offset);
                    }
                    // delete the word in head
                    offset = s.substring(start - n, start);
                    occurrenceDiffer.put(offset, occurrenceDiffer.getOrDefault(offset, 0) - 1);
                    if (occurrenceDiffer.get(offset) == 0) {
                        occurrenceDiffer.remove(offset);
                    }
                }
                if (occurrenceDiffer.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
