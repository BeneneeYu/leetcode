package slidingWindow.question3;

import java.util.Arrays;

/* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



 */
public class Solution {
  //枚举从每一个位开始的最长不重复子串，那么其中最长的就是所求的
  //观察到，每当起始位置向后移，结束位置也必定后移，这是可以推断的
  //因此可以使用滑动窗口法
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    char[] chars = s.toCharArray();
    if (n <= 1){
      return n;
    }
    int l = 0;
    int r = 0;
    int maxLength = 0;
    int tmpLength = 0;
    int[] times = new int[95];
    Arrays.fill(times, -1);
    while (l < n){
      while (r < n){
        if (times[chars[r] - ' '] >= 1){
          System.out.println(s.substring(l,r));
          maxLength = Math.max(maxLength,tmpLength);
          times[chars[l]- ' '] = times[chars[l]- ' '] - 1;
          l++;
          tmpLength--;
          System.out.println("遇到" + chars[r] + ",tmpLength--");
          break;
        }else{
          times[chars[r] - ' ']++;
          tmpLength++;
          System.out.println("遇到" + chars[r] + ",tmpLength++");
          r++;
        }
      }
      if (r == n){
        return Math.max(maxLength,tmpLength);
      }
    }
    return maxLength;
  }
  //更好的方法，通过记录上一次出现的位置，直接跳过前一个重复
  public int lengthOfLongestSubstring2(String s) {
    // 记录字符上一次出现的位置
    int[] last = new int[128];
    for(int i = 0; i < 128; i++) {
      last[i] = -1;
    }
    int n = s.length();

    int res = 0;
    int start = 0; // 窗口开始位置
    for(int i = 0; i < n; i++) {
      int index = s.charAt(i);
      start = Math.max(start, last[index] + 1);
      res   = Math.max(res, i - start + 1);
      last[index] = i;
    }

    return res;
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(s.lengthOfLongestSubstring("au"));

  }
}
