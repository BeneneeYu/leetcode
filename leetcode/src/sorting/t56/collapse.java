package sorting.t56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class collapse {
    class myComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0]-o2[0]);
        }

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals,new myComparator());
        ArrayList<int[]> arrayList = new ArrayList<>();
        int num = 0;
        arrayList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (arrayList.get(num)[1]>= intervals[i][0] && arrayList.get(num)[1] < intervals[i][1]){
                arrayList.get(num)[1] = intervals[i][1];
            }
            else if (arrayList.get(num)[1] < intervals[i][0]){
                arrayList.add(intervals[i]);
                num++;
            }
        }
        int[][] result = new int[num+1][2];

        for (int i = 0; i <= num; i++) {
            result[i][0] = arrayList.get(i)[0];
            result[i][1] = arrayList.get(i)[1];

        }
        return result;
    }

    public static void main(String[] args) {
        collapse a = new collapse();
        int[][] temp = {{1,4},{4,5},{3,11}};
        System.out.println(a.merge(temp)[0][0]);
        System.out.println(a.merge(temp)[0][1]);
        System.out.println(a.merge(temp)[1][0]);
        System.out.println(a.merge(temp)[1][1]);
    }
}
