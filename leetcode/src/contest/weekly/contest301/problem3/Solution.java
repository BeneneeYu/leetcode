package contest.weekly.contest301.problem3;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-10 10:20
 **/
public class Solution {
    public boolean canChange(String start, String target) {
        char[] startChar = start.toCharArray();
        char[] targetChar = target.toCharArray();
        StringBuilder startRel = new StringBuilder();
        StringBuilder tarRel = new StringBuilder();
        ArrayList<Integer> startLIndex = new ArrayList<>();
        ArrayList<Integer> startRIndex = new ArrayList<>();
        ArrayList<Integer> tarLIndex = new ArrayList<>();
        ArrayList<Integer> tarRIndex = new ArrayList<>();
        for (int i = 0; i < startChar.length; i++) {
            char c = startChar[i];
            if (c == 'L'){
                startLIndex.add(i);
                startRel.append("L");
            }else if (c == 'R'){
                startRIndex.add(i);
                startRel.append("R");
            }
        }
        for (int i = 0; i < targetChar.length; i++) {
            char c = targetChar[i];
            if (c == 'L'){
                tarLIndex.add(i);
                tarRel.append("L");
            }else if (c == 'R'){
                tarRIndex.add(i);
                tarRel.append("R");
            }
        }
        if (startLIndex.size() != tarLIndex.size() || startRIndex.size() != tarRIndex.size() || !startRel.toString().equals(tarRel.toString())) return false;
        for (int i = 0; i < startLIndex.size(); i++) {
            if (startLIndex.get(i) < tarLIndex.get(i)) return false;
        }
        for (int i = 0; i < startRIndex.size(); i++) {
            if (startRIndex.get(i) > tarRIndex.get(i)) return false;
        }
        return true;
    }
}
