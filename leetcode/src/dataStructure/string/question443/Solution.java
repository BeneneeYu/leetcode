package dataStructure.string.question443;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-07 16:17
 **/
public class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int indexPlaced = 0;
        while (index < chars.length) {
            char curChar = chars[index];
            int count = 0;
            while (index < chars.length && curChar == chars[index]) {
                index += 1;
                count += 1;
            }
            chars[indexPlaced++] = curChar;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[indexPlaced++] = c;
                }
            }
        }
        return indexPlaced;
    }
}
