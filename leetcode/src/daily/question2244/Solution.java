package daily.question2244;

import java.util.HashMap;

/*

You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.


 */
public class Solution {
    // 1 -1
    // 2 1
    // 3 1
    // 4 2
    // 5 2
    // 6 2
    // 7 3
    // 8 3
    // 9 3
    // 10 4
    // 11 4
    // 12 4
    // 13 5
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Integer diff : count.keySet()) {
            int times = count.get(diff);
            if (times == 1){
                return -1;
            }else{
                if (times % 3 == 0){
                    res += times / 3;
                }else{
                    res += (times / 3) + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
