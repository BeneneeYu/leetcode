package dynamicProgramming.math.question258;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-08 10:05
 **/
public class Solution {
    //num = x*100+y*10+z = x*99+y*9+x+y+z, so that num % 9 = sum of all individual digits,
    // result( num % 9) belongs to [0,8]
    // when num = 9n, result should be 9
    // so use result((num - 1) % 9 + 1)
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
