package dataStructure.string.question205;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-17 09:00
 **/
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mappingDictStoT = new int[256];
        char[] charsOfS = s.toCharArray();
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        char[] charsOfT = t.toCharArray();

        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = charsOfS[i];
            char c2 = charsOfT[i];

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
}
