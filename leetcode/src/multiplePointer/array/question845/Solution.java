package multiplePointer.array.question845;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-13 13:12
 **/
public class Solution {
    public int longestMountainDoublePointer(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int left = 0;
        while (left < n - 2) { // least mountain length is 3
            int right = left + 1;
            if (arr[left] < arr[left + 1]) { // possible mountain
                while (right < n - 1 && arr[right] < arr[right + 1]) { // increasing
                    ++right;
                }
                if (right < n - 1 && arr[right] > arr[right + 1]) {
                    while (right < n - 1 && arr[right] > arr[right + 1]) {
                        ++right;
                    }
                    // mountain stops
                    ans = Math.max(ans, right - left + 1);
                } else { // arr[right] == arr[right + 1] || right == n - 1 (impossible to form a mountain)
                    ++right;
                }
            }
            // right mountain foot can be left another left mountain foot
            left = right;
        }
        return ans;
    }

    public int longestMountainDynamicProgramming(int[] arr) {
        // enumerate mountain top
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                right[i - 1] = right[i] + 1;
            } else {
                right[i - 1] = 0;
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            if (left[i] != 0 && right[i] != 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }
}
