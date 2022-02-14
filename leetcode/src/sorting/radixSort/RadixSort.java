package sorting.radixSort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-14 11:46
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 222, 4, 123, 142, -33, 166, 433, 999, 11, 44, 5, 233, 423, -33, 88};
        RadixSort radixSort = new RadixSort();
        int maxDigitLen = radixSort.getMaxDigitLen(nums);
        radixSort.radixSort(nums, maxDigitLen);
        System.out.println(Arrays.toString(nums));
    }

    private int getMaxDigitLen(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumOfDigits(maxValue);
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

    protected int getNumOfDigits(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10; // to obtain the digit to compare
        int dev = 1; // to abandon the compared digits

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // to handle negative integers，extend the key range，[0-9] is for negative，[10-19] is for positive (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod; // plus mod to give offset
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) { // Partially ordered
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
