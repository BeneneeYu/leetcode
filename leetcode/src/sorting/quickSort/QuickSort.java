package sorting.quickSort;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-03-31 21:04
 **/
public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = new int[]{1, 3, 222, 4, 12312, 19248, -33, 1213, 4283, 999, 4123, 44, 5, 2123123123, 423, 4123123, 88};
        q.quickSort(nums, 0, nums.length - 1);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right){
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
        return nums;
    }

    public int partition(int[] nums, int left, int right){
        int pivot = left;
        int curIndex = pivot + 1; // elements before curIndex are definitely smaller than nums[pivot]
        for (int i = curIndex; i <= right; i++) {
            if (nums[i] < nums[pivot]){
                swap(nums, i, curIndex);
                curIndex += 1;
            }
        }
        swap(nums, pivot, curIndex - 1); // select nums[curIndex - 1], which is smaller, to swap, so that nums[curIndex - 1] is a partitionIndex
        return curIndex - 1;
    }

    // swap
    public void swap(int[] num, int left, int right) {
        if (left == right) return;
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}