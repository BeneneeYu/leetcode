package multiplePointer.array.question80;

/**
 * @program: Leetcode
 * @description: at most twice
 * @author: Shen Zhengyu
 * @create: 2022-06-11 20:19
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        int validPtr = 2;
        int detectPtr = 2;
        while (detectPtr < len) {
            if (nums[detectPtr] != nums[validPtr - 2]) { // non-decreasing order
                nums[validPtr] = nums[detectPtr];
                validPtr++;
            }
            detectPtr++;
        }
        return validPtr;
    }
}
