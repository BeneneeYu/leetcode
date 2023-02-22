package binarySearch.simpleBinarySearch.question1011;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class Solution {
    public int shipWithinDays(int[] weights, int days) {

        // there is a capacity n
        // we can't ship the packages with capacity smaller than n
        // we can ship them with capacity n or greater than n
        int maxWeight = 0;
        int sumWeight = 0;
        for (int weight : weights) {
            sumWeight += weight;
            maxWeight = Math.max(weight, maxWeight);
        }
        int lo = maxWeight;
        int hi = sumWeight;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = 1;
            int shipped = 0;
            // greedy to see if capacity-mid is too big or small
            for (int weight : weights) {
                if (shipped + weight > mid) {
                    curr += 1;
                    shipped = 0;
                }
                shipped += weight;
                if (curr > days) {
                    break;
                }
            }
            if (curr > days) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
