# Question

You are given an array `target` of n integers. From a starting array `arr` consisting of `n` 1's, you may perform the following procedure :

- let `x` be the sum of all elements currently in your array.
- choose index `i`, such that `0 <= i < n` and set the value of `arr` at index `i` to `x`.
- You may repeat this procedure as many times as needed.

Return `true` *if it is possible to construct the* `target` *array from* `arr`*, otherwise, return* `false`.

```
Input: target = [9,3,5]
Output: true
Explanation: Start with arr = [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done
```

# Idea

At last, the biggest number in the array is the last to be set, which is the sum of array in the last round. Mark the biggest number as `s == sum'`, the sum of array in this round is `sum`. 

`sum - s` is the sum of array except for the biggest number, `s` is the sum of array in the last round. The number replaced is `s - (sum - s)`. So that we can reverse every operation.

If the biggest number is the biggest before set operation, the difference is the same, which is the sum of all other elements. The reverse operation will not affect the all other elements and their sum.

