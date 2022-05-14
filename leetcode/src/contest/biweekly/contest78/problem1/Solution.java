package contest.biweekly.contest78.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-14 22:30
 **/
public class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int digit = numStr.length();
        int res = 0;
        if (k == 0 || k > digit) return 0;
        for (int i = 0; i <= (digit - k); i++) {
            int tmpNum = Integer.parseInt(numStr.substring(i, i+k));
            if (tmpNum == 0) continue;
            if (num % tmpNum == 0){
                res += 1;
            }
        }
        return res;
    }
}
