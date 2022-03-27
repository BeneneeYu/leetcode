package contest.weekly.contest286.problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-27 10:30
 **/
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(helper(nums1, nums2));
        result.add(helper(nums2, nums1));
        return result;
    }

    private List<Integer> helper(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set.remove(i);
        }
        return new ArrayList<>(set);
    }
}
