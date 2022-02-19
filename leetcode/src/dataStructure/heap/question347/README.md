# Question

Given an integer array `nums` and an integer `k`, return *the* `k` *most frequent elements*. You may return the answer in **any order**.

**Constraints:**

- `1 <= nums.length <= 105`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is **guaranteed** that the answer is **unique**.

**Follow up:** Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size. (=>heap)

# Solution

We can design a class with num value and its occurrence times. Or we can just use an array with a length of two, where `array[0]` represents num value and `array[1]` represents its occurrence times.



