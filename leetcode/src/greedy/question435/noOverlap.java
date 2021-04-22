package greedy.question435;

import java.util.Arrays;
import java.util.Comparator;

public class noOverlap {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, new myComparator());
            int end = intervals[0][1] ;
            int[] prev = intervals[0];
            int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[1]){
                prev = intervals[i];
            }else if (intervals[i][0] < prev[1] && intervals[i][1] > prev[1]){
                count++;
            }
            else{
                count++;
                prev = intervals[i];
            }
        }
        return count;
    }
//        public int eraseOverlapIntervals(Interval[] intervals) {
//            if (intervals.length == 0) {
//                return 0;
//            }
//            Arrays.sort(intervals, new myComparator());
//            int end = intervals[0].end, prev = 0, count = 0;
//            for (int i = 1; i < intervals.length; i++) {
//                if (intervals[prev].end > intervals[i].start) {
//                    if (intervals[prev].end > intervals[i].end) {
//                        prev = i;
//                    }
//                    count++;
//                } else {
//                    prev = i;
//                }
//            }
//            return count;
//        }
public static void main(String[] args) {
    noOverlap n = new noOverlap();
    int[][] a = new int[][]{{1,2},{2,4},{3,4}};
    System.out.println(n.eraseOverlapIntervals(a));
}
}
