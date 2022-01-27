package dynamicProgramming.question91;

public class Solution {
  public int numDecodings(String s) {
    int n = s.length();
    s = " " + s;
    char[] cs = s.toCharArray();
    int[] f = new int[3];
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
      f[i % 3] = 0;
      int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
      if (1 <= a && a <= 9) f[i % 3] = f[(i - 1) % 3];
      if (10 <= b && b <= 26) f[i % 3] += f[(i - 2) % 3];
    }
    return f[n % 3];
  }

  public static void main(String[] args) {
    String s1 = "12";
    String s2 = "11106";
    Solution s = new Solution();
    System.out.println(s.numDecodings(s1));
    System.out.println(s.numDecodings(s2));
  }
}
