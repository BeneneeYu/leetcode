package binarySearch.conditionalBinarySearch.question81;
/*已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。


 */
/*
对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，此时无法判断区间 [l,mid] 和区间 [mid+1,r] 哪个是有序的。

例如 {nums}=[3,1,2,3,3,3,3]，target=2，首次二分时无法判断区间[0,3]和区间[4,6] 哪个是有序的。

对于这种情况，我们只能将当前二分区间的左边界加一，右边界减一(中间的还在，可以找到他），然后在新区间上继续二分查找。

 */
public class Solution {
  public boolean search(int[] nums, int target) {
    if (null == nums || nums.length == 0){
      return false;
    }
    int start = 0;
    int end = nums.length-1;
    //利用二分法，判断是前一半有序还是后一半有序，然后在可能范围内寻找
    while (start <= end){
      System.out.println("start=" + start + ",end=" + end);
      int mid = (start + end) / 2;
      System.out.println("mid=" + mid);
      if (nums[mid] == target){
        return true;
      }
      //只有[3,1,2,3,3,3,3]才不能判断，如果[3,1,2,3,3,3,4]可以判断后半段有序
      if (nums[start] == nums[mid] && nums[start] == nums[end]) {
        start++;
        end--;
      }else if(nums[start] < nums[mid] || nums[mid] > nums[end]){
        if (nums[start] <= target && target <= nums[mid]){
          end = mid - 1;
        }else{
          start = mid + 1;
        }
      }else if(nums[start] > nums[mid] || nums[mid] < nums[end]){
        if (nums[mid] <= target && target <= nums[end]){
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }else{
        System.out.println("error");
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1
    },2));
  }
}
