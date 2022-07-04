package contest.weekly.contest300.problem1;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-03 10:17
 **/
public class Solution {
    public String decodeMessage(String key, String message) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        char[] keyChar = key.toCharArray();
        int cnt = 0;
        for (int i = 0; i < key.length(); i++) {
            if (keyChar[i] == ' ') continue;
            if (pos[keyChar[i] - 'a'] == -1){
                pos[keyChar[i] - 'a'] = cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' '){
                sb.append(' ');
            }else{
                sb.append((char)('a' + pos[c - 'a']));
            }
        }
        return sb.toString();
    }
}
