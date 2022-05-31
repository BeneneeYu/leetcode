package daily.question318;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-29 11:19
 **/
public class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int len = words.length;
        int[] masks = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i] = (masks[i] | 1 << (words[i].charAt(j) - 'a'));
            }
        }
        for (int i = 0; i < masks.length; i++) {
            for (int j = i + 1; j < masks.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
