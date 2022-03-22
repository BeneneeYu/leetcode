package dynamicProgramming.greedy.question1663;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-22 08:42
 **/
public class Solution {
    public String getSmallestString(int n, int k) {
        if ((double) (k / n) > 26.0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int toPlace = getSmallestNumber(i, k);
            sb.append((char) ('a' + (toPlace - 1)));
            k -= toPlace;
            if ((double) (k / i) == 26.0) {
                for (int j = 0; j < i; j++) {
                    sb.append('z');
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private int getSmallestNumber(int i, int k) {
        return Math.max(1, k - 26 * (i - 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSmallestString(3, 54));
        System.out.println(s.getSmallestString(3, 27));
        System.out.println(s.getSmallestString(5, 73));
    }
}
