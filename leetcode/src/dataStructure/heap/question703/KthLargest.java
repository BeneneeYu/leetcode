package dataStructure.heap.question703;

import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description: Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @author: Shen Zhengyu
 * @create: 2022-04-08 08:33
 **/

class KthLargest {
    PriorityQueue<Integer> heap;
    int size;
    public KthLargest(int k, int[] nums) {
        this.size = k; // kth largest is the smallest in the largest k elements
        heap = new PriorityQueue<>();
        for (int num : nums) {
            add(num); // maintain the k largest from start
        }
    }

    public int add(int val) {
        heap.offer(val);
        // when a new value is offered, the root node may change, let the heap justify itself
        if (heap.size() > size){
            heap.poll(); // after which the k largest elements are all in the heap
        }
        return heap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
