package contest.weekly.contest301.problem1;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-10 10:20
 **/
public class Solution {
    public int fillCups(int[] amount) {
        int times = 0;
        int all = 0;
        for (int i : amount) {
            all += i;
        }
        while (true){
            Arrays.sort(amount);
            int filled = 0;
            for (int i = 2; i >= 0; i--) {
                if (amount[i] > 0 && filled < 2){
                    amount[i] -= 1;
                    filled += 1;
                    all -= 1;
                }
            }
            System.out.println(Arrays.toString(amount));
            times += 1;
            if (all == 0) return times;
        }
    }
}
