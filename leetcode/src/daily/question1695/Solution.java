package daily.question1695;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-12 19:45
 **/
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] += nums[i - 1] + preSum[i - 1];
        }
        while (right < len) {
            if (lastIndex.containsKey(nums[right])) {
                res = Math.max(preSum[right] - preSum[left], res);
                left = Math.max(left, lastIndex.get(nums[right]) + 1);
                lastIndex.put(nums[right], right);
            }
            lastIndex.put(nums[right], right);
            right += 1;
        }
        res = Math.max(preSum[right] - preSum[left], res);
        return res;
    }
}
