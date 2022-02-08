package dataStructure.complexDataStructure.question528;

import java.util.Random;

/**
 * @program: leetcode
 * @description:You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 * <p>
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 * <p>
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 * @author: Shen Zhengyu
 * @create: 2022-02-08 20:07
 **/
public class Solution {
    int[] preArray;
    int total;

    public Solution(int[] w) {
        int wLength = w.length;
        preArray = new int[wLength];
        preArray[0] = w[0];
        total = w[0];
        for (int i = 1; i < wLength; i++) {
            preArray[i] = preArray[i - 1] + w[i];
            total += w[i];
        }
    }

    public int pickIndex() {
        int randomNum = (int) (Math.random() * total) + 1;
        return binarySearch(randomNum);
    }

    private int binarySearch(int x) {
        int low = 0;
        int high = preArray.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (preArray[mid] < x) {
                low = mid + 1; // in case mid is persistent but number to search is bigger than array[low]
            } else {
                high = mid;
            }
        }
        return low;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */