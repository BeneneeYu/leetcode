# Question

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight **without alerting the police***.

# Ideas

Consider from one direction!

Considering that the maximum total amount of each house is only related to the maximum total amount of the first two houses of the house... Use variables.

# Solution

K is the total number of houses.

1. $K == 1$, rob it.
2. $K == 2$, rob the house that has more money.
3. $K > 2$, 
   1. If you rob house `k`, you can not rob house `k-1`, the maximum amount is the sum of money in house `k` and the maximum amount of the previous `k-2` houses.
   2. If you do not rob house k, the maximum amount is the maximum amount of the previous `k-1` houses.

An array dp[n] indicates the maximum amount you can rob.