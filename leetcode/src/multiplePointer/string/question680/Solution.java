package multiplePointer.string.question680;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-02 10:09
 **/
public class Solution {
    public boolean validPalindrome(String s) {
        int chance = 1;
        int low = 0;
        int length = s.length();
        int high = length - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return helper(s.substring(low, high)) || helper(s.substring(low + 1, high + 1));
//                return (helper2(s, low, high - 1) || helper2(s, low + 1, high));
            } else {
                low += 1;
                high -= 1;
            }
        }
        return true;
    }

    private boolean helper(String s) {
        int low = 0;
        int length = s.length();
        int high = length - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low += 1;
            high -= 1;
        }
        return true;
    }

    private boolean helper2(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
