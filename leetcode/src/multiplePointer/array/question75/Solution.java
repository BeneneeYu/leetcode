package multiplePointer.array.question75;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-11 16:33
 **/
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // [0, zero), [zero, i), [two, len - 1], at first they are null
        int zero = 0;
        int two = len;
        int i = 0;
        // i == two, cover all the array
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero); // move to the front
                zero++; // maintain the property
                i++; // observe the next element
            } else if (nums[i] == 1) {
                i++; // will not affect p0 and p2
            } else {
                // we don't know what is swapped to here
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
