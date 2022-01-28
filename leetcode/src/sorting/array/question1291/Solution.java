package sorting.array.question1291;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-23 14:27
 **/
class Solution {
    //An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
    //
    //Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
    public List<Integer> sequentialDigits(int low, int high) {
        // When the number is n-digit, for example 3-digit.
        // The base is 123, to try next possible number, 111 should be added, and we should try 10-3 times.
        int start = 1;
        int cur = 1; // The ongoing tested number
        int added = 11;
        int times = 8;
        List<Integer> answerList = new ArrayList<>();
        while (cur <= high){
            for (int i = 0; i < times; i++) {
                cur += added;
                if (cur >= low && cur <= high) answerList.add(cur);
            }
            added = added * 10 + 1;
            //1+11, 12+111, 123+1111,
            start = start * 10 + 10 - times;
            cur = start;
            times--;
        }
        return answerList;
    }

}
