package singleScan.question941;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-25 10:10
 **/
public class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        boolean isAscending = arr[1] > arr[0];
        if (!isAscending) return false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) return false;
            if (isAscending){
                if (arr[i] < arr[i-1]) isAscending = false;
            }else{ // mountain down way
                if (arr[i] >= arr[i-1]) return false;
            }
        }
        return !isAscending;
    }
}
