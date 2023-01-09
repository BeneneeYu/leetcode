# Question

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A **subsequence** is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, `[3,6,2,7]` is a subsequence of the array `[0,3,1,6,2,2,7]`.

# Solution

## DP

dp[i]: tailed with nums[i], the max length of strictly increasing subsequence, for nums[0...i-1], if nums[i] > nums[j], dp[i] = dp[j] + 1(appended), the final value should be the maximum value.

Every `i` can be the tail of  final answer subsequence.

## Greedy+Binary

To make the increasing subsequence as long as possible, we should increase the subsequence as slowly as possible, indicating that the last number to append should be as small as possible.

Based on which, we maintain an array `d[i]`, representing the minimum value of a increasing subsequence of length `i`. `len` is the longest length now. `d[i]` is monotonically increasing as `i` increases.

Traverse the array from front to back, for `nums[i]`

- If $nums[i] > d[len]$, it can be appended to array `d`, `len = len + 1`
- Or, do binary search in array `d`, find the largest number `d[k]` which is smaller than `d[k]`, let $d[k+1] = nums[i]$, which means construct a new subsequence of length `k+1` tailed with smaller number

Monotonicity of array `d` make binary search work, and the length of `d` is the final answer.