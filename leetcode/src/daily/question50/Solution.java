package daily.question50;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-25 22:03
 **/
public class Solution {
    public double myPow(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
