package dataStructure.arrayAndMatrix.question525;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-04 08:53
 **/
public class Solution {
    // good case to use prefix sum
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> positionMap = new HashMap<>();
        int cnt = 0; // difference between 1 and 0, count(1) - count(0)
        positionMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt += ((num == 1) ? 1 : -1);
            if (positionMap.containsKey(cnt)){
                maxLength = Math.max(maxLength, i - positionMap.get(cnt));
            }else{
                positionMap.put(cnt, i);
            }
        }
        return maxLength;
    }

    public int findMaxLength2(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int[] posArray = new int[2*n+1];
        Arrays.fill(posArray, -2);
        posArray[n] = -1;
        int cnt = 0; // difference between 1 and 0, count(1) - count(0)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt += ((num == 1) ? 1 : -1);
            if (posArray[cnt + n] > -2){
                maxLength = Math.max(maxLength, i - posArray[cnt + n]);
            }else{
                posArray[cnt + n] = i;
            }
        }
        return maxLength;
    }
}
