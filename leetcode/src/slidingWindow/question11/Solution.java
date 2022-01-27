package slidingWindow.question11;
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。取两根作为壁板，求最大容积。

说明：你不能倾斜容器。

 */
public class Solution {
  //试探所有的可能，是O(n^2)
  //采用双指针法，当两根中一根较短，要向反方向移动，为什么是移动它不是移动另一个？
  //双指针一开始放到左右两边，每当遇到较小的，就离开它，向内尝试，因为认为它不能作为容器的壁。
  //假设一开始左x右y，且x<y，则容量是x*t，因为容量是由最短边决定的，所以必将左指针向右移动（移动右指针没用）
  //这时左指针原来的位置就废弃了，不可能用它能得到更大的（哪怕右指针尝试所有的情况），极端情况，最大就是x*t。
  //得到新的，可以用这个思路继续处理
  public int maxArea(int[] height) {
    int max = 0;
    int l = 0;
    int r = height.length - 1;
    while (l < r){
      max = Math.max(max,(r-l)*Math.min(height[l],height[r]));
      if (height[l] >= height[r]){
        r--;
      }else{
        l++;
      }
    }
    return max;
  }
}
