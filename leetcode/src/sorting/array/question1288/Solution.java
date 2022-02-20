package sorting.array.question1288;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-20 09:44
 **/
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                // start point ascending
                // end point descending
                (int[] o1, int[] o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0])
        );
        int count = 0;
        int end = 0;
        int prevEnd = 0;
        for (int[] interval : intervals) {
            end = interval[1];
            if (prevEnd < end) {
                count++; // remained
                prevEnd = end;
            }
        }
        return count;
    }
}
