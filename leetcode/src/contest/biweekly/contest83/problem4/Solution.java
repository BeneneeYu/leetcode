package contest.biweekly.contest83.problem4;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-23 22:26
 **/
public class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int[] times = new int[k]; // times[k-1] : times of k
        int n = rolls.length;
        int[] differentSeq = new int[n + 1]; // differentSeq[n]: length = n, different seq nums
        differentSeq[0] = 1;
        for (int i = 0; i < n; i++) {
            int res = rolls[i];
            int time = times[res - 1] + 1;
            times[res - 1] = time;
            for(int j = i + 1; j >= time; j--){
                differentSeq[j] += (differentSeq[j-1] - time + 1);
            }
            System.out.println(Arrays.toString(differentSeq));
        }
        for (int i = 1; i < n; i++) {
            if (differentSeq[i] < Math.pow(k, i)){
                return i;
            }
        }
        return k;
    }
}
