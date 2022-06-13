package multiplePointer.array.question215;

import java.util.Random;

/**
 * @program: Leetcode
 * @description: Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @author: Shen Zhengyu
 * @create: 2022-06-13 10:00
 **/
public class Solution {
    private final static Random random = new Random(System.currentTimeMillis());


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1); // random int in [left, right]
        swap(nums, left, randomIndex); // random number goes to the head

        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1; // less or equals
        int ge = right; // greater or equals
        while (true) {
            while (le <= ge && nums[le] <= pivot) {
                le += 1;
            }

            while (le <= ge && nums[ge] >= pivot) {
                ge -= 1;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le += 1;
            ge -= 1;

        }
        swap(nums, left, ge);
        return ge; // ge <= le
    }

    private void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }
}
