package dynamicProgramming.others.question70;
/*
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class Solution {
  public int climbStairs(int n) {
    //count[n]->n级楼梯时的攀爬方法数目
    if (n == 1)return 1;
    //i=2
    //a代表爬i-2楼梯方法数
    //b代表爬i-1楼梯方法数
    //c代表爬i楼梯方法数
    int a=0,b=1,c=2;
    //i -> i+1
    for (int i = 3; i <= n; i++) {
      a = b;
      b = c;
      c = a+b;
    }
    return c;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.climbStairs(2));
    System.out.println(s.climbStairs(3));
    System.out.println(s.climbStairs(4));
  }
}
