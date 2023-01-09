package contest.weekly.contest327.problem1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Arrays.sort(nums);
        for(int i = 0; i < k && i <= nums.length - 1; i++){
            pq.offer(nums[nums.length - i - 1]);
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            int biggest = pq.poll();
            res += biggest;
            pq.offer((int) Math.ceil(biggest / 3.0));
        }
        return res;
    }
}
