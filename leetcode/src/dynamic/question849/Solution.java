package dynamic.question849;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-16 17:40
 **/
public class Solution {
    /*
    Let left[i] be the distance from seat i to the closest person sitting to the left of i.
    Similarly, let right[i] be the distance to the closest person sitting to the right of i.
    This is motivated by the idea that the closest person in seat i sits a distance min(left[i], right[i]) away.
    To construct left[i], notice it is either left[i-1] + 1 if the seat is empty, or 0 if it is full. right[i] is constructed in a similar way.
     */
    public int maxDistToClosest1(int[] seats) {
        int length = seats.length;
        int[] left = new int[length]; // Focus only on the limit from left side
        int[] right = new int[length]; // Focus only on the limit from right side
        Arrays.fill(left, length); // For example, if seats[length-1] == 0, right[length-1] should be length because it doesn't focus on the left side
        Arrays.fill(right, length);
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else if (i >= 1) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else if (i < length - 1) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = Math.max(ans, Math.min(left[i], right[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxDistToClosest1(new int[]{1,0,0,0});
    }
}