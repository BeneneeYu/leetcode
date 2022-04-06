package multiplePointer.array.question923;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-06 09:45
 **/
public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int remaining = target - arr[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] < remaining) {
                    j += 1;
                } else if (arr[j] + arr[k] > remaining) {
                    k -= 1;
                } else {
                    if (arr[j] == arr[k]) {
                        res += (k - j + 1) * (k - j) / 2;
                        res %= mod;
                        break;
                    } else {
                        int jCount = 1;
                        int kCount = 1;
                        while (arr[j] == arr[j + 1]) {
                            j += 1;
                            jCount += 1;
                        }
                        while (arr[k] == arr[k - 1]) {
                            k -= 1;
                            kCount += 1;
                        }
                        res += jCount * kCount;
                        res %= mod;
                        j += 1;
                        k -= 1;
                    }
                }
            }
        }
        return (int) res;
    }
}
