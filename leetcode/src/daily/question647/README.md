# Question

Given a string `s`, return *the number of **palindromic substrings** in it*.

A string is a **palindrome** when it reads the same backward as forward.

A **substring** is a contiguous sequence of characters within the string.

# Solution

## Dynamic Programming

We can infer from the result of shorter substring.

if `dp[i][j]` then `s` in `[i,j]` is a palindromic substring

if `s[i] == s[j] && (j - i < 2 || dp[i+1][j-1])`,`dp[i][j] == true`

It refers to the three situations, the substring only contains one character, the substring contains two characters and they are the same and the substring two same characters wrap is a palindromic substring.