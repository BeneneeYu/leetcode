package array.question33;
/*整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。


 */
public class Solution {
  public int search(int[] nums, int target) {
    if (null == nums || nums.length == 0){
      return -1;
    }
    int start = 0;
    int end = nums.length-1;
    //利用二分法，判断是前一半有序还是后一半有序，然后在可能范围内寻找
    while (start <= end){
      System.out.println("start=" + start + ",end=" + end);
      int mid = (start + end) / 2;
      System.out.println("mid=" + mid);
      if (nums[mid] == target){
        return mid;
      }
      if (nums[start] <= nums[mid]){
        if (nums[start] <= target && target <= nums[mid]){
          end = mid - 1;
        }else{
          start = mid + 1;
        }
      }else{
        if (nums[mid] <= target && target <= nums[end]){
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.search(new int[] { 4,5,6,7,0,1,2 }, 0));
  }
}
