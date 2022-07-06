package multiplePointer.array.oppositeDirection.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-18 16:15
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == nums || nums.length < 3) return res;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // same triplets have been tried
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = len - 1;
            int target = -nums[i]; // nums[j] + nums[k] == target
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // can't skip j == i + 1 cause there is no duplications now
                    continue;
                }
                // this while loop breaks when (i,j,k) is a possible answer
                while (j < k && nums[j] + nums[k] > target) {
                    k -= 1;
                }
                // not possible now and never
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
                // continue to try
            }
        }
        return res;
    }
}
