# Question

Given an integer array `nums`, find a contiguous non-empty subarray within the array that has the largest product, and return *the product*.

The test cases are generated so that the answer will fit in a **32-bit** integer.

A **subarray** is a contiguous subsequence of the array.

**Example 1:**

```
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

# Idea

The optimal solution of the current position may not be transfered from the optimal solution of the previous position. We should classify and discuss according to whether $a_i$ is positive or negative.

If $a_i < 0$, we expect the product of a subarray that ends in its previous position to be a negative number and its absolute value should be as large as possible. If $ai > 0$