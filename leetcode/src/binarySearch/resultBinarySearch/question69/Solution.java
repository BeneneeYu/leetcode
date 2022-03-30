package binarySearch.resultBinarySearch.question69;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-30 08:51
 **/
public class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            // mid * mid may be bigger than 2^31-1
            if ((long) mid * mid <= x) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
