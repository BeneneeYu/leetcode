# Question

An integer array is called arithmetic if it consists of **at least three elements** and if the difference between any two consecutive elements is the same.

- For example, `[1,3,5,7,9]`, `[7,7,7,7]`, and `[3,-1,-5,-9]` are arithmetic sequences.

Given an integer array `nums`, return *the number of arithmetic **subarrays** of* `nums`.

A **subarray** is a contiguous subsequence of the array.

# Ideas

We can enumerate any two successive elements as the end of a subarray, and do a forward traversal to try. The time complexity will be $O(n^2)$.

But there is some information that we can use, if we have figured out the number $t_i$, which indicates the number of eligible new subarrays for answer when $nums[i-1]$ and $nums[i]$ are tails, we can also figure out $t_k,k=i+1$ in an simple way.

- If $nums[i]$ - $nums[i+1]$ = $d$, $t_k=t_i+1$
- Else $tk = 0$

