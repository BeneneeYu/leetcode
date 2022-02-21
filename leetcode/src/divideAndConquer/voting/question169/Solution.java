package divideAndConquer.voting.question169;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-21 10:54
 **/
public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return nums[0];
        }
        Integer candidate = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
