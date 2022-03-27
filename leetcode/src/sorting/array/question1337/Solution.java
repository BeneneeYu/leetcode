package sorting.array.question1337;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-27 08:45
 **/
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            power.add(new int[]{countSoldiers(mat[i]) + 1, i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        // initialize heap first
        for (int[] ints : power) {
            pq.offer(ints);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;
    }

    // binary search
    private int countSoldiers(int[] people) {
        int l = 0;
        int r = people.length - 1;
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (people[mid] == 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
                pos = mid;
            }
        }
        return pos;
    }
}
