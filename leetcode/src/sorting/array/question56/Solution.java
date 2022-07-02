package sorting.array.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * @author: Shen Zhengyu
 * @create: 2022-07-02 15:37
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] intervalToAdd = intervals[0];
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] thisInterval = intervals[i];
            // should create a new interval
            if (thisInterval[0] > intervalToAdd[1]) {
                res.add(intervalToAdd);
                intervalToAdd = intervals[i];
            } else {
                // just prolong the interval
                intervalToAdd[1] = Math.max(intervalToAdd[1], thisInterval[1]);
            }
        }
        res.add(intervalToAdd);
        return res.toArray(new int[][]{});
    }
}
