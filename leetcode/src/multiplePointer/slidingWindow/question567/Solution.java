package multiplePointer.slidingWindow.question567;

/**
 * @program: leetcode
 * @description: Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * @author: Shen Zhengyu
 * @create: 2022-02-11 12:29
 **/
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // corner case
        if (s1.length() > s2.length()) return false;
        int[] timeOfChar1 = new int[26];
        int[] timeOfChar2 = new int[26];
        char[] charOfS1 = s1.toCharArray();
        char[] charOfS2 = s2.toCharArray();
        for (int i = 0; i < charOfS1.length; i++) {
            timeOfChar1[charOfS1[i] - 'a'] += 1;
            timeOfChar2[charOfS2[i] - 'a'] += 1;
        }
        for (int i = 0; i < (charOfS2.length - charOfS1.length); i++) {
            if (isPermutation(timeOfChar1, timeOfChar2)) {
                return true;
            }
            timeOfChar2[charOfS2[i] - 'a'] -= 1;
            timeOfChar2[charOfS2[i + charOfS1.length] - 'a'] += 1;
        }
        return isPermutation(timeOfChar1, timeOfChar2);
    }

    public boolean optimizedCheckInclusion(String s1, String s2) {
        // corner case
        if (s1.length() > s2.length()) return false;
        int[] timeOfChar1 = new int[26];
        int[] timeOfChar2 = new int[26];
        char[] charOfS1 = s1.toCharArray();
        char[] charOfS2 = s2.toCharArray();
        int diff = 0; // count of same char that appear different times
        for (int i = 0; i < charOfS1.length; i++) {
            timeOfChar1[charOfS1[i] - 'a'] += 1;
            timeOfChar2[charOfS2[i] - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (timeOfChar1[i] != timeOfChar2[i]) {
                diff += 1;
            }
        }

        for (int i = 0; i < (charOfS2.length - charOfS1.length); i++) {
            int r = charOfS2[i + charOfS1.length] - 'a';
            int l = charOfS2[i] - 'a';
            if (diff == 0) return true;
            if (timeOfChar2[r] == timeOfChar1[r]) {
                diff++;
            }
            timeOfChar2[r]++;
            if (timeOfChar1[r] == timeOfChar2[r]) {
                diff--;
            }else if (timeOfChar2[r] - 1 == timeOfChar1[r]){ // switch from same number
                diff++;
            }
            timeOfChar2[l]--;
            if (timeOfChar2[l] == timeOfChar1[l]) {
                diff--;
            }else if (timeOfChar2[l] + 1 == timeOfChar1[l]){ // switch from same number
                diff++;
            }
        }
        return diff == 0;
    }

    private boolean isPermutation(int[] times1, int[] times2) {
        for (int i = 0; i < times1.length; i++) {
            if (times1[i] != times2[i]) {
                return false;
            }
        }
        return true;
    }
}
