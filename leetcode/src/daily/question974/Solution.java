package daily.question974;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 */
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // when it comes to contiguous subarray, use prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int modulus = (sum % k + k) % k;
            // how many subarray before this subarray has the same modulus, the gap subarray is an answer
            int same = map.getOrDefault(modulus, 0);
            res += same;
            map.put(modulus, same + 1);
        }
        return res;
    }
}
