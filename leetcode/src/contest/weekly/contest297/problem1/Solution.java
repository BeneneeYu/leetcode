package contest.weekly.contest297.problem1;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-12 10:25
 **/
public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int prev = 0;
        double taxSum = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0];
            if (income <= prev) break;
            double taxRate = bracket[1] / 100.0;
            int toTax = Math.min(income, upper);
            taxSum += (double)((toTax - prev) * taxRate);
            prev = upper;
        }
        return taxSum;
    }
}
