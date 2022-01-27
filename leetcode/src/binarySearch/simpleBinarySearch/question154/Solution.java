package binarySearch.simpleBinarySearch.question154;
/*
已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。

 */
public class Solution {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
    while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
      int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
      if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
        left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
      } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
        right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
      }else{ //加上的条件
        right--;
      }
    }
    return nums[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findMin(new int[]{2,4,5,6,7,0,1}));
    System.out.println(s.findMin(new int[]{7,0,1,2,4,5,6}));

  }
}
