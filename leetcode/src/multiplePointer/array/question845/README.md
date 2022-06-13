# Question

You may recall that an array `arr` is a **mountain array** if and only if:

- `arr.length >= 3`
- There exists some index `i` (**0-indexed**) with `0 < i < arr.length - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
  - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given an integer array `arr`, return *the length of the longest subarray, which is a mountain*. Return `0` if there is no mountain subarray.

# Idea

- Dynamic Programming
- Double Pointer

# Solution

## Dynamic Programming

`left[i]` represents the maximum length of increasing sequence of which the end point is index[i]

`right[i]` represents the maximum length of decreasing sequence of which the start point is index[i]

there exists a recursion relation based on relation

If `left[i] != 0 && right[i] != 0`, i is the mountain top, the length of mountain is `left[i] + right[i] + 1`

## Double Pointer

pointer left and pointer right point at left mountain foot and right mountain foot