package daily.question905;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-02 08:08
 **/
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left += 1;
            }
            while (left < right && nums[right] % 2 == 1) {
                right -= 1;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            // left is odd and right is even
            if (A[i] % 2 > A[j] % 2) {
                swap(A, i, j);
            }

            // move or stay
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
