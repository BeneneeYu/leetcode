package dataStructure.string.question14;

/**
 * @program: Leetcode
 * @description: Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * @author: Shen Zhengyu
 * @create: 2022-04-07 14:55
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        return verticalScan(strs);
    }

    private String horizontalScan(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(commonPrefix) != 0) { // -1 or n mean strs[i] doesn't start with common prefix, prefix should be shorten
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                if (commonPrefix.length() == 0) {
                    return "";
                }
            }
        }
        return commonPrefix;
    }

    private String verticalScan(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            // i: the index of potential common char, strs[0][0,i-1] is verified
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // j: traversal on the whole string array
                if (i == strs[j].length() || strs[j].charAt(i) != tmp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
