package array.question27;
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 */
public class Solution {
  public int removeElement(int[] nums, int val) {
    int left = 0;
    int right = nums.length;
    //当左指针小于右指针，即还没有遍历完数组所有元素
    while (left < right) {
      //如果是需要覆盖的目标值，取右指针指向的值，如果它也是目标值，可以继续用下一个覆盖
      if (nums[left] == val) {
        nums[left] = nums[right - 1];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }
  public int removeElement2(int[] nums, int val) {
    int left = 0;
    int right = nums.length-1;
    //当左指针小于右指针，即还没有遍历完数组所有元素
    while (left <= right) {
      //如果是需要覆盖的目标值，取右指针指向的值，如果它也是目标值，可以继续用下一个覆盖
      if (nums[left] == val) {
        nums[left] = nums[right];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }
}
