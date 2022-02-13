package sorting.bucketSort;

import sorting.quickSort.QuickSort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-13 16:16
 **/
public class BucketSort {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] nums = new int[]{1, 223, 463, 881, 216, 442, 348, 719}; // positive integer in successive range
        bucketSort.bucketSort(nums, 100);
        System.out.println(Arrays.toString(nums));
    }

    QuickSort quickSort = new QuickSort();

    private int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1; // map according to number size range

        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            bucket = quickSort.quickSort(bucket, 0, bucket.length - 1);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    // like ArrayList
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
