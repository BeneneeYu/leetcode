package backtrack.question46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /*给定一个 没有重复 数字的序列，返回其所有可能的全排列。

   */
  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int num : nums) {
      arrayList.add(num);
    }
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    ArrayList<Integer> result = new ArrayList<>();
    helper(results,arrayList,result);
    return results;
  }
  public void helper(List<List<Integer>> results,List<Integer> remain,List<Integer> result){
    if(remain.isEmpty()){
      results.add(new ArrayList<>(result));//因为result是可变的，需要加一个snapshot
    }else{
      ArrayList<Integer> options = new ArrayList<>(remain);
      for (Integer integer : options) {
        result.add(integer);
        remain.remove(integer);
        helper(results,remain,result);
        result.remove(integer);
        remain.add(integer);
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.permute(new int[] { 1, 2, 3 }));
  }
}
