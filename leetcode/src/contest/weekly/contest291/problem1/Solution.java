package contest.weekly.contest291.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-01 10:17
 **/
public class Solution {
    public String removeDigit(String number, char digit) {
        int lastIndex = 0;
        for (int i = 0; i < number.length(); i++) {
            char tmp = number.charAt(i);
            if (tmp == digit){
                lastIndex = i;
                if (i < number.length() - 1 && number.charAt(i) < number.charAt(i+1)){
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (i == lastIndex) continue;
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}
