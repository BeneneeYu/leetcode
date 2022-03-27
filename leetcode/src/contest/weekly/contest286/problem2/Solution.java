package contest.weekly.contest286.problem2;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-27 10:35
 **/
public class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int toDelete = 0;
        int ptr = 1;
        ArrayList<Integer> resultNums = new ArrayList<>();
        resultNums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (ptr % 2 == 1 && nums[i] == resultNums.get(resultNums.size() - 1)){
                toDelete += 1;
            }else{
                resultNums.add(nums[i]);
                ptr += 1;
            }
        }
        if (resultNums.size() % 2 == 1) toDelete += 1;
        return toDelete;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1,1,2,3,5};
        int[] nums2 = new int[]{1,1,2,2,3,3,4,4};
        System.out.println(s.minDeletion(nums1));
        System.out.println(s.minDeletion(nums2));
    }
}
