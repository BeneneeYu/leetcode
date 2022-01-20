package binarySearch.question875;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-20 08:14
 **/
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        while (minSpeed < maxSpeed) {
            int midSpeed = (minSpeed + maxSpeed) / 2;
            int cntHour = 0;
            for (int pile : piles) {
                cntHour += Math.ceil((double) pile / midSpeed);
            }
            if (cntHour > h){ // eat too slow
                minSpeed = midSpeed + 1;
            }else{
                maxSpeed = midSpeed;
            }
        }
        return maxSpeed;
    }
}
