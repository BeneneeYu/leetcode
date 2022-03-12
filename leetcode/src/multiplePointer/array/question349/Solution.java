package multiplePointer.array.question349;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-12 17:38
 **/
public class Solution {
    //Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] times = new int[1001];
        for (int i : nums1) {
            times[i] += 1;
        }
        int n = 0;
        int[] potentialIntersection = new int[1001];
        for (int i : nums2) {
            if (times[i] > 0) {
                times[i] = 0;
                potentialIntersection[n] = i;
                n += 1;
            }
        }
        int[] res = new int[n];
        System.arraycopy(potentialIntersection, 0, res, 0, n);
        return res;
    }
}
