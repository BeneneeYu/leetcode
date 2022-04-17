package contest.weekly.contest289.problem2;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-17 10:28
 **/
public class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> times = new HashMap<>();
        for (int taskDifficulty : tasks) {
            times.put(taskDifficulty, times.getOrDefault(taskDifficulty, 0) + 1);
        }
        int completeTime = 0;
        for (Integer integer : times.keySet()) {
            int num = times.get(integer);
            if (num <= 1) {
                return -1;
            } else {
                if (num % 3 == 0) {
                    completeTime += num / 3;
                } else {
                    completeTime += (int) (num / 3);
                    completeTime += 1;
                }
            }
        }
        return completeTime;
    }
}
