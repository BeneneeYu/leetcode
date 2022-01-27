package dynamicProgramming.greedy.question134;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-21 08:03
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length != cost.length) return -1;
        s:
        for (int i = 0; i < length; i++) { // Select every station as start point.
            int gasLeft = 0;
            if (gas[i] == 0) continue;
            gasLeft = gas[i];
            for (int j = 0; j < length; j++) { // Try to reach other stations.
                gasLeft -= cost[(i + j) % length];
                if (gasLeft < 0) continue s;
                gasLeft += gas[(i + j + 1) % length];
            }
            return i;
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int currentStation = 0;
        int validStation = 0;
        int gasRemaining = 0;
        int gasRemainingPrevious = 0;
        while (currentStation < gas.length) {
            gasRemaining += gas[currentStation] - cost[currentStation];
            if (gasRemaining < 0) {
                validStation = currentStation + 1;
                gasRemainingPrevious += gasRemaining;
                gasRemaining = 0;
            }
            currentStation++;
        }
        if (gasRemainingPrevious + gasRemaining < 0)
            return -1;
        else
            return validStation;
    }

    public static void main(String[] args) {
        int[] gas = {5, 4, 2, 3};
        int[] cost = {3, 4, 5, 1};
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
