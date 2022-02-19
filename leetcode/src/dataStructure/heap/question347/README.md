# Question

Given an integer array `nums` and an integer `k`, return *the* `k` *most frequent elements*. You may return the answer in **any order**.

**Constraints:**

- `1 <= nums.length <= 105`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is **guaranteed** that the answer is **unique**.

**Follow up:** Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size. (=>heap)

# Solution

We can design a class with num value and its occurrence times. Or we can just use an array with a length of two, where `array[0]` represents num value and `array[1]` represents its occurrence times.

Firstly, count the occurrences of every element so we can get a map. After that we maintain a min heap and do traversal on the occurrence map, when the size is smaller than k, we can offer every single element we encounter. But if the size of heap reaches k, we should compare the element we encounter with the peek element, if its occurrences is smaller, it's unnecessary to offer it to the heap.

After the traversal, we get the first K frequent numbers.

