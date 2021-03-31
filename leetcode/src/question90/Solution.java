package question90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

*/
public class Solution {

  ArrayList<List<Integer>> res = new ArrayList<>();

  ArrayList<Integer> one_path = new ArrayList<>();//一个可能的子集

  int n;

  int[] nums;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    this.nums = nums;
    n = nums.length;
    //先排序，这样相同的两个元素必相邻
    Arrays.sort(nums);
    backtarck(0);
    res.add(new ArrayList<Integer>());//补上一个空集
    return res;
  }

  private void backtarck(int i) {//将要填入下标为i的元素，也就是说该层从nums[i]处的元素开始for循环
    if (i == n) {
      System.out.println("已经遍历到数组尾部");
      return;
    }
    System.out.println("以第" + i + "个元素开始遍历");
    //再dfs地加子节点
    for (int j = i; j < n; j++) {//做的是子集，子集是组合，所以是从当前元素开始遍历
      if (j > i && nums[j] == nums[j - 1]) {
        System.out.println("下标i为" + i + "时:位于位置" + j + "的元素" + nums[j] + "和位置" + (j-1) + "的元素" + nums[j-1] + "重复" );
        continue;//同层重复，跳过
      }
      if(one_path.size() >= 1 && nums[j] == one_path.get(one_path.size()-1)){
        System.out.println("同树枝重复,i=" + i + ",j=" + j);
      }
      one_path.add(nums[j]);
      res.add(new ArrayList<Integer>(one_path));
      System.out.println("得到一个结果" + one_path);
      backtarck(j + 1);
      one_path.remove(one_path.size() - 1);//撤销选择
      System.out.println("因为已经遍历到尾部，所以回溯后将path重新置为" + one_path);
    }
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 2, 2 };
    int[] nums2 = { 0 };
    Solution solution = new Solution();
    System.out.println(solution.subsetsWithDup(nums1));
    System.out.println("——————————————————————————————————————————————");
    Solution solution1 = new Solution();
    System.out.println(solution1.subsetsWithDup(nums2));

  }
}
