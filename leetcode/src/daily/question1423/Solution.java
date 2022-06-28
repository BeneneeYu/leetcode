package daily.question1423;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-26 15:49
 **/
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int start = len - k;
        int sum = 0;
        for (int i = start; i < len; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = start; i < len; i++) {
            sum -= cardPoints[i];
            sum += cardPoints[(i + k) % len];
            max = Math.max(max, sum);
        }
        return max;
    }
}
