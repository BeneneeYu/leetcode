package dataStructure.monotonicStack.question316;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-18 09:13
 **/
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] times = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            times[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (!visited[i]) { // if the same character is already in stack, no need to proceed
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) { // to get the smallest in lexicographical order and make previous string qualified
                    if (times[sb.charAt(sb.length() - 1) - 'a'] > 0) { // if alternative characters exist
                        // remove
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                // already qualified and 'c' is able to append
                visited[i] = true;
                sb.append(c);
            }
            // 'c' is consumed
            times[i] -= 1;
        }
        return sb.toString();
    }
}
