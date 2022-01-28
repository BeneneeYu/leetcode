package dataStructure.monotonicStack.question300;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Shen Zhengyu
 * @create: 2021-04-03 15:56
 **/
public class lengthOfLIS {
    /*
    dp[i] = max(dp[j])+1 and 0 <= j < i,num[j] < num[i]
     */
    public int meth1(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int[] dp = new int[nums.length];//dp[i]是以num[i]为结尾的最长递增子序列
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    /*基于贪心思路，上升尽可能慢，希望加在子序列上的数字尽可能小

     */
    public int meth2(int[] nums){
        int len = 1, n = nums.length;//len表示最长上升子序列的长度
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];//d[i]表示长度为i+1的最长上升子序列的末尾元素的最小值，d[i]是单调递增的
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {//最长长度+1
                d[++len] = nums[i];
            } else {//更新d[i]=nums[j]
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
    public static void main(String[] args) {
        lengthOfLIS l = new lengthOfLIS();
        System.out.println(l.meth1(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(l.meth2(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
