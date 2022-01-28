package dynamicProgramming.greedy.question605;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-18 08:05
 **/
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxPlanted = 0;
        int length = flowerbed.length;
        int i = 0;

        while (i < length){
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)){
                flowerbed[i] = 1;
                maxPlanted++;
            }
            if (maxPlanted >= n) return true;
            i++;
        }
        return false;
    }
}
