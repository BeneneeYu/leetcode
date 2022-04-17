package contest.weekly.contest289.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-17 10:28
 **/
public class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int times = k;
            int tmp = 0;
            boolean remained = s.length() % k > 0;
            for (char c : s.toCharArray()) {
                tmp += Integer.parseInt(String.valueOf(c));
                times--;
                if (times == 0) {
                    times = k;
                    sb.append(tmp);
                    tmp = 0;
                }
            }
            if (remained){
                sb.append(tmp);
            }
            s = sb.toString();
        }
        return s;
    }
}
