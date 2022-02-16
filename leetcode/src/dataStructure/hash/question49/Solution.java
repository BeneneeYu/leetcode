package dataStructure.hash.question49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-16 12:35
 **/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            int[] times = new int[26];
            for (char c : tmp) {
                times[c - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times.length; i++) {
                if (times[i] != 0){
                    sb.append((char)(i + 'a'));
                    sb.append(times[i]);
                }
            }
            // This is false because it is not unambiguous, 101 0 & 10 10?
//            for (int time : times) {
//                sb.append(time);
//            }
            List<String> anagrams;
            anagrams = resultMap.getOrDefault(sb.toString(), new ArrayList<>());
            anagrams.add(str);
            resultMap.put(sb.toString(), anagrams);
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (List<String> groupAnagram : s.groupAnagrams(new String[]{"bddddddddddadddd", "bbbbbbbbbbc"})) {
            System.out.println(groupAnagram);
        }
    }
}
