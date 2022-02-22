package dataStructure.arrayAndMatrix.question171;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-22 10:19
 **/
public class Solution {
    public int titleToNumber(String columnTitle) {
        if (null == columnTitle) return -1;
        int len = columnTitle.length();
        char[] chars = columnTitle.toUpperCase().toCharArray();
        int result = 0;
        for (char aChar : chars) {
            result *= 26;
            result += aChar - 'A' + 1;
        }
        return result;
    }
}
