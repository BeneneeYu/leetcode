package dataStructure.string.question13;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description: For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * @author: Shen Zhengyu
 * @create: 2022-04-07 09:39
 **/
public class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int tmp = symbolValues.get(chars[i]);
            if (tmp < symbolValues.get(chars[i + 1])) {
                res -= tmp;
            } else {
                res += tmp;
            }
        }
        res += symbolValues.get(chars[chars.length - 1]);
        return res;
    }
}
