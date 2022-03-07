package dynamicProgramming.greedy.question763;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-07 09:36
 **/
public class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> partition = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(lastIndex[chars[i] - 'a'], end);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
