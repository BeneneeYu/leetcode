package multiplePointer.array.oppositeDirection.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description: Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * @author: Shen Zhengyu
 * @create: 2022-07-05 18:41
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        // fix the first number
        for (int i = 0; i < len - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue; // skip duplicated
            if (longAdd(new int[]{nums[i], nums[i + 1], nums[i + 2], nums[i + 3]}) > target) {
                break;
            } // too large
            if (longAdd(new int[]{nums[i], nums[len - 1], nums[len - 2], nums[len - 3]}) < target) {
                continue;
            }// too small
            // fix the second number
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (longAdd(new int[]{nums[i], nums[j], nums[j + 1], nums[j + 2]}) > target) {
                    break;
                }
                if (longAdd(new int[]{nums[i], nums[j], nums[len - 1], nums[len - 2]}) < target) {
                    continue;
                }
                int m = j + 1;
                int n = len - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[m + 1]) {
                            m += 1;
                        }
                        m += 1;
                        while (n > m && nums[n] == nums[n - 1]) {
                            n -= 1;
                        }
                        n -= 1;
                    } else if (sum > target) {
                        n -= 1;
                    } else {
                        m += 1;
                    }
                }
            }
        }
        return res;
    }


    // to avoid integer overflow in intermediate process
    private long longAdd(int[] intArray) {
        long sum = 0;
        for (int i : intArray) {
            sum += (long) i;
        }
        return sum;
    }
}
