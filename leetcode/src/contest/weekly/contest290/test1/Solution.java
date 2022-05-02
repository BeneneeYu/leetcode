package contest.weekly.contest290.test1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-23 17:12
 **/
public class Solution {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int minTime = 0;
        for (int i = 0; i < fruits.length; i++) {
            int type = fruits[i][0];
            int num = fruits[i][1];
            int times = num % limit == 0 ? num / limit : num / limit + 1;
            minTime += times * time[type];
        }
        return minTime;
    }
}
