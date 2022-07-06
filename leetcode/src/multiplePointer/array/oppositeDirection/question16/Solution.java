package multiplePointer.array.oppositeDirection.question16;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-05 11:40
 **/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // fix the same number
        for (int i = 0; i < len; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            // Shrink from both sides to the center
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = sum - target;
                int gapAbs = Math.abs(gap);
                if (gapAbs == Math.min(gapAbs, minGap)) {
                    res = sum;
                    minGap = gapAbs;
                }
                if (gap == 0) {
                    return target;
                } else if (gap > 0) {
                    int k0 = k - 1;
                    while (k0 > j && nums[k0] == nums[k]) {
                        k0 -= 1;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0 += 1;
                    }
                    j = j0;
                }
            }
        }
        return res;
    }
}
