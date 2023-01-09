package contest.weekly.contest327.problem3;

import java.util.*;

public class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] occ1 = new int[26];
        int[] occ2 = new int[26];
        int num1 = 0;
        int num2 = 0;
        for (char c : word1.toCharArray()) {
            if(0 == occ1[c-'a']){
                num1 += 1;
            }
            occ1[c-'a'] += 1;
        }
        for (char c : word2.toCharArray()) {
            if(0 == occ2[c-'a']){
                num2 += 1;

            }
            occ2[c-'a'] += 1;
        }
        int diff = Math.abs(num1 - num2);
        if (diff > 2){
            return false;
        }
        for (int i = 0; i < 26; i++) { // str1 to give
            if(occ1[i] == 0) continue;
            for (int j = 0; j < 26; j++) { // str2 to give
                if (occ2[j] == 0) continue;
                if(i == j ){
                    if(diff == 0){
                        return true;
                    }else{
                        continue;
                    }
                }
                int newNum1 = num1;
                int newNum2 = num2;
                if (occ2[j] == 0) continue;

                if (occ1[j] == 0) newNum1 += 1;
                if (occ2[i] == 0) newNum2 += 1;
                if (occ1[i] == 1) newNum1 -= 1;
                if (occ2[j] == 1) newNum2 -= 1;
                if (newNum1 == newNum2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isItPossible("a", "bb");
    }
}
