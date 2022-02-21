# Question

The **median** is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

Implement the MedianFinder class:

- `MedianFinder()` initializes the `MedianFinder` object.
- `void addNum(int num)` adds the integer `num` from the data stream to the data structure.
- `double findMedian()` returns the median of all elements so far. Answers within `10-5` of the actual answer will be accepted.

**Constraints:**

- `-105 <= num <= 105`
- There will be at least one element in the data structure before calling `findMedian`.
- At most `5 * 104` calls will be made to `addNum` and `findMedian`.

# Solution

## Priority Queue

To maintain the `median`, we can use two priority queues, one of which, `queueMax`(minHeap) maintains all the numbers bigger than median, the other, `queMin`(maxHeap) maintains all the numbers smaller than or equal to the median.

- When the number of integers is odd, `sizeof(queMin) = sizeof(queMax) + 1`, when the median is the peek of queMin.
- When the number of integers is even, `sizeof(queMin) = sizeof(queMax)`, the median is the average of two peek of the two heaps.

### AddNum

To generify the condition, the median must be in queMin (if the number of elements is odd).

- `num <= max{queMin}`, num should be added to queMin, the new median may be smaller than the original one, so that we may should remove the maximum number in `queMin` to `queMax`.
- `num > max{queMin}`, num should be added to queMax, the new median may be bigger than the original one, so that we may should remove the minimum number in `queMax` to `queMin`.

## Ordered Set and Double Pointers

Ordered Set (e.g. TreeSet) can be regarded as array that can be sorted automatically.

The double pointers should point at the same number (when the number of elements is odd) or the middle two elements.

When we try to add a number `num` to set,

1. The set is empty, let double pointers point at the position of num
2. Size(set) is odd, the double pointers point at the median. If num is bigger than or equal to the median, move `right` toward right by one step. Or move `left` toward left by one step.
3. Size(set) is even,
   1. Num is the new and unique median, remove `left` toward right by one, and remove `right` toward left by one.
   2. Num is bigger or equal than `right`, move `left` toward right.
   3. Num is smaller than `right`, move `right` toward left, if `num` is equal to `left`, cause it will be inserted to right side of `left`, `left` should be aligned with `right`.