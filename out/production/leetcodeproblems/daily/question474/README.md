# Question

You are given an array of binary strings `strs` and two integers `m` and `n`.

Return *the size of the largest subset of `strs` such that there are **at most*** `m` `0`*'s and* `n` `1`*'s in the subset*.

A set `x` is a **subset** of a set `y` if all elements of `x` are also elements of `y`.

# Solution

`dp[i][j][k]` represents the largest number of strings we can get using `j` `0`'s and `k` `1`'s within the first `i` strings

When `i == 0`, `dp[i][j][k] == 0`



