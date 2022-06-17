package template.sorting.quickSort;

import java.util.Random;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-14 21:10
 **/
public class Solution {
    private final static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right <= left) return;
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1); // random int in [left, right]
        swap(nums, randomIndex, left);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (le <= ge) {
            while (le <= ge && nums[le] <= pivot) {
                le += 1;
            }
            while (le <= ge && nums[ge] >= pivot) {
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
}
