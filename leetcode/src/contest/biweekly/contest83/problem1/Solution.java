package contest.biweekly.contest83.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-23 22:25
 **/
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rankTimes = new int[14];
        int[] suitTimes = new int[4];
        for (int rank : ranks) {
            rankTimes[rank] += 1;
        }
        for (char suit : suits) {
            suitTimes[suit - 'a'] += 1;
        }
        for (int suitTime : suitTimes) {
            if (suitTime == 5){
                return "Flush";
            }
        }
        int biggest = 1;
        for (int rankTime : rankTimes) {
            biggest = Math.max(biggest, rankTime);
        }
        if (biggest >= 3){
            return "Three of a Kind";
        }else if (biggest == 2){
            return "Pair";
        }else{
            return "High Card";
        }
    }
}
