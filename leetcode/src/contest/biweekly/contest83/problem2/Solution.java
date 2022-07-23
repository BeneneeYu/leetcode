package contest.biweekly.contest83.problem2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-23 22:25
 **/
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int cont = 0;
        long res = 0;
        for (int num : nums) {
            if (num == 0){
                cont += 1;
                res += cont;
            }else{
                cont = 0;
            }
        }
        return res;
    }
}
