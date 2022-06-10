package multiplePointer.range.question633;

/**
 * @program: Leetcode
 * @description: Given a non-negative integer c, decide whether there're two integers a and b such that a^2 + b^2 = c.
 * @author: Shen Zhengyu
 * @create: 2022-06-10 12:12
 **/
public class Solution {
    public boolean judgeSquareSum(int c) {
        // the answer is [0, a, b, sqrt(c)]
        int a = 0;
        int b = (int)Math.sqrt(c);
        while (a <= b){
            // there is a case that: integer overflow when judging
            int tmp = a * a + b * b;
            if (tmp < 0) b -= 1; // handle the overflow case
            if (tmp == c) return true;
            if (tmp > c){
                b -= 1;
            }else{
                a += 1;
            }
        }
        return false;
    }
}
