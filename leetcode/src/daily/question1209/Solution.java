package daily.question1209;

import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-06 20:33
 **/
public class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)){
                counts.push(1);
            }else{
                int incremented = counts.pop();
                incremented += 1;
                if (incremented == k){
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }else{
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
