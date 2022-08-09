package daily.question823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-08-08 20:28
 **/
public class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n]; // dp[v]: number of ways to make a tree with the vth node as root
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        } // value and number
        // sorted
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[map.get(right)] * dp[j]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (long l : dp) {
            ans += l;
        }
        return (int) (ans % mod);
    }
}
