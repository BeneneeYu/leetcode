package multiplePointer.slidingWindow.question438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-02 09:03
 **/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] cnt = new int[26];
        List<Integer> resultList = new ArrayList<>();
        if (p.length() > s.length()) return resultList;
        for (char c : p.toCharArray()) {
            cnt[c - 'a'] += 1;
        }
        int len = p.length();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < len; i++) {
            cnt[sChar[i] - 'a'] -= 1;
        }
        int head = 0;
        int tail = len - 1;
        while (tail < s.length() - 1) {
            if (checkEmpty(cnt)) {
                resultList.add(head);
            }
            cnt[sChar[head] - 'a'] += 1;
            head++;
            tail++;
            cnt[sChar[tail] - 'a'] -= 1;
        }
        if (checkEmpty(cnt)) {
            resultList.add(head);
        }
        return resultList;
    }

    public boolean checkEmpty(int[] array) {
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


}
