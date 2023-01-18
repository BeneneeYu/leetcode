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
        int nl = newInterval[0];
        int nr = newInterval[1];
        int len = intervals.length;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while (j < len && nl > intervals[j][1]) res.add(intervals[j++]);
        // when the code reaches here, the left is in an interval
        // try to expand the right
        while (j < len && nr >= intervals[j][0]) {
            nl = Math.min(nl, intervals[j][0]);
            nr = Math.max(nr, intervals[j++][1]);
        }
        // expansion is done
        res.add(new int[]{nl, nr});
        while (j < len) {
            res.add(intervals[j++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
