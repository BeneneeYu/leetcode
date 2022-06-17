package template.doublePointer;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-17 19:58
 **/
public class Solution {
    // opposite-direction (in quick sort)
    private int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int pivot = nums[left];
        int le = left + 1, ge = right;
        while (le <= ge) {
            while (le <= ge && nums[le] < pivot) {
                le += 1;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge -= 1;
            }
            if (le <= ge) {
                swap(nums, le, ge);
                le += 1;
                ge -= 1;
            }
        }
        swap(nums, ge, left);
        return ge;
    }
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    // back-facing

    // same-direction
}
