package contest.weekly.contest296.problem2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-05 10:26
 **/
public class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int prevMin = nums[0];
        if (nums.length == 1) return 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prevMin > k){
                res += 1;
                prevMin = nums[i];
            }
        }
        return res;
    }
}
