package doublePointer.question633;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class Solution {
  public boolean judgeSquareSum(int c) {
    int a = 0;
    int b = (int)Math.sqrt(c) + 1;
    while (a <= b){
      int sum = a*a + b*b;
      if (sum == c){
        return true;
      }else if (sum > c){
        b--;
      }else{
        a++;
      }
    }
    return false;
  }
/*
  为什么这是正确的？可以把它看作一个矩阵搜索的过程
  格子在搜索过程中只有两种行为：
搜索过程中：
小于 c ：左边的元素都小于当前元素，只能下移，相当于low++。此时排除的是黄色格子以及左边同行的元素，都小于 cc ，所以不会错过正确答案。
大于 c ：下面的元素都大于当前元素，只能左移，相当于high--。此时排除的是黄色格子以及下方同列的元素，都大于 cc ，所以不会错过正确答案。

 */
  public static void main(String[] args) {

  }
}
