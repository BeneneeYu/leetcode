package contest.weekly.contest291.problem3;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-01 11:40
 **/
public class MySolution {
    int res = 0;
    HashSet<int[]> mySet = new HashSet<>();
    public int countDistinct(int[] nums, int k, int p) {
        dfs(nums, new int[0], 0,0, k,p);
        for (int[] ints : mySet) {
            System.out.println(Arrays.toString(ints));
        }
        return mySet.size();
    }
    private void dfs(int[] nums, int[] preNums, int index, int kNum, int k, int p){
        if (kNum > k) return;
        res += 1;
        int[] newNums = new int[preNums.length + 1];
        System.arraycopy(preNums, 0, newNums, 0, preNums.length - 1);
        for (int i = index; i < nums.length; i++) {
            newNums[preNums.length] = nums[index];
            if (nums[index] % p == 0) kNum += 1;
            mySet.add(newNums);
            dfs(nums, newNums, i, kNum,k,p);
        }
    }
}
