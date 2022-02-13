package sorting.countingSort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-13 15:52
 **/
public class CountingSort {
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] nums = new int[]{1, 3, 3, 88, 21, 44, 38, 19}; // positive integer in successive range
        cs.countingSort(nums, cs.getMaxValue(nums));
        System.out.println(Arrays.toString(nums));
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen]; // key is element value, value is element appearance times

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0; // result array current placing index pointer
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) { // until all the elements have this value are placed
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
