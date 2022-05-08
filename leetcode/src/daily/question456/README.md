# Question

Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return *`true` if there is a **132 pattern** in `nums`, otherwise, return `false`.*

# Idea

We should think about how to find the other two numbers after a number is determined. We use `ijk` to represent `132` structure.

1. Enumerate `i`: Cause `i` is the smallest number in `132`, we should find `(j,k)`, which makes `j` and `k` bigger than `i`, and `j>k`. The traversal is one-way, so that we should find `k` at first, and find a bigger number between `i` and `k`.
2. Enumerate `j`: Cause `j` is the biggest number in `132`, we should find the biggest number on the right side which is smaller than `j`, and the smallest number on the left side which is smaller than `j`(because `i` must be smaller than `j`). According to which, we figure out monotonic stack.
3. Enumerate `k`: Cause `k` is the middle number, we should find `i` on the left side, and make sure that there is a number `j` between `i` and `k` of index and is bigger.

# Solution

We enumerate `i`.

Traverse from back to front, maintain a monotonic decreasing stack, and record the biggest value among all the popped elements with `k`.

When we traverse to `i`, if `nums[i] < k`, we have found `ijk`.

For example, `[3,1,4,2]`, the qualified subsequence is `[1,4,2]`.

1. Traverse into 2: The stack is `[2]`, `k` = INF
2. Traverse into 4: Not decreasing, so we pop `2` and push `4`, set `k` as 2.
3. Traverse into 1: `nums[i] < k`, it showes that a bigger element is after `i`, and it is poped because there exists a bigger element than it.

The core is that we find qualified `(j,k)` by keep the stack monotonic decreasing. If k has value, there exists `j > k`.

  