package daily.question191;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-26 10:10
 **/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // << i means shifts i bit pattern to the left
            // 1 << i means only the ith digit is 1, so that we can verify the ith digit of n
            if ((n & (1 << i)) != 0) {
                res += 1;
            }
        }
        return res;
    }

    public int hammingWeightOptimized(int n) {
        // n & (n-1) turns the 1 of lowest digit to zero
        int res = 0;
        while (n != 0) { // can not be > 0
            n = (n & (n - 1));
            res += 1;
        }
        return res;
    }
}
