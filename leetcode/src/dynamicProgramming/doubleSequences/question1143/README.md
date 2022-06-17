# Question

Given two strings `text1` and `text2`, return *the length of their longest **common subsequence**.* If there is no **common subsequence**, return `0`.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

- For example, `"ace"` is a subsequence of `"abcde"`.

A **common subsequence** of two strings is a subsequence that is common to both strings.

# Idea

2D dynamic programming problem.

Consider the recursion, define `length(text1) = m, length(text2) = n`, `dp[i][j]` represents the length of longest common subsequence between `text1[0,i]` and `text2[0,j]`.

Consider the corner case and general case.

# Solution

- `dp[0][j] == dp[i][0] == 0`
- `i > 0 && j > 0`
  - `text1[i-1] == text2[j-1]`, `dp[i][j] = dp[i-1][j-1] + 1`
  - `text1[i-1] != text2[j-1]`, `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`