package dataStructure.string.question520;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-24 08:30
 **/
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        char[] chars = word.toCharArray();
        if (isCapital(chars[0])){
            if (isCapital(chars[1])){
                for (int i = 2; i < chars.length; i++) {
                    if (!isCapital(chars[i])){
                        return false;
                    }
                }
            }else{
                for (int i = 2; i < chars.length; i++) {
                    if (isCapital(chars[i])){
                        return false;
                    }
                }
            }
        }else{
            for (int i = 1; i < chars.length; i++) {
                if (isCapital(chars[i])){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isCapital(char c){
        return  (c >= 'A' && c <= 'Z');
    }
}
