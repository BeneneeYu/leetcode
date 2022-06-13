# Question

Given an integer array `nums` and an integer `k`, return *the* `kth` *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

# Idea

To find the `(n - k)th` smallest element in the array.

Quick selection is an algorithm based on quick sort that infers an element's position after sorting through one pass.

Select a pivot + Partition + Recursion

# Solution

## Partition

Pass and swap

The head element acts as the pivot:

When we see a new element

- `<=` pivot: swap it was the first element in the `>` section
- `>` pivot: pass

swap pivot with the first element of `>` section

### loop invariant

`pivot`: nums[left]

`le`: `<=` section

`ge`: `>=` section

`nums[left+1, le)`: `<=` section

`nums(ge, right]`: `>` section