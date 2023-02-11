package multiplePointer.slidingWindow.question438;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) {
            return result;
        }
        int[] pOcc = new int[26];
        for (int i = 0; i < pLen; i++) {
            pOcc[p.charAt(i) - 'a'] += 1;
        }
        int l = 0;
        int r = pLen - 1;
        int[] sOcc = new int[26];
        for (int i = l; i < r; i++) {
            sOcc[s.charAt(i) - 'a'] += 1;
        }
        while (r < sLen) {
            sOcc[s.charAt(r) - 'a'] += 1;
            if (isAnagram(pOcc, sOcc)) {
                result.add(l);
            }
            sOcc[s.charAt(l) - 'a'] -= 1;
            l += 1;
            r += 1;
        }
        return result;

    }

    private boolean isAnagram(int[] s1, int[] s2) {
        if (s1.length != s2.length) return false;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }
}
