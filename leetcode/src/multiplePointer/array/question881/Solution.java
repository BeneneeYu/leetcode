package multiplePointer.array.question881;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-24 09:18
 **/
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boatCount = 0;
        while (left <= right) {
            boatCount += 1;
            if (people[left] + people[right] <= limit) {
                left += 1;
            }
            right -= 1;
        }
        return boatCount;
    }
}
