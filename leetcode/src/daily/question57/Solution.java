package daily.question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-25 21:40
 **/
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1], n = intervals.length, index = 0;
        ArrayList<int[]> intervalsList = new ArrayList<>();
        while (index < n && intervals[index][1] < left) {
            intervalsList.add(intervals[index++]);
        }
        while (index < n && intervals[index][0] <= right) {
            left = Math.min(intervals[index][0], left);
            right = Math.max(intervals[index][1], right);
            index += 1;
        }
        intervalsList.add(new int[]{left, right});
        while (index < n) {
            intervalsList.add(intervals[index++]);
        }
        return intervalsList.toArray(new int[intervalsList.size()][]);
    }
}
