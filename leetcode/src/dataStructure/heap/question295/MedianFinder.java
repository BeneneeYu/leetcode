package dataStructure.heap.question295;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-19 14:59
 **/
public class MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        queueMin = new PriorityQueue<>((a, b) -> (b - a)); // Max heap, all elements are less than or equal to median
        queueMax = new PriorityQueue<>((a, b) -> (a - b)); // Min heap, all elements are bigger than median, default implementation in JDK
    }

    public void addNum(int num) {
        // to Min heap
        if (queueMin.isEmpty() || num <= queueMin.peek()) { // if odd, the median must be im queueMin to generify the condition
            queueMin.offer(num);
            // if queMax.size + 1 == queMin.size, no need to remove because the added num is less than the new median
            // if queMax.size + 2 == queMin.size, has to remove or the two middle values will be both in queueMin
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) { // odd
            return queueMin.peek();
        }
        return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}
