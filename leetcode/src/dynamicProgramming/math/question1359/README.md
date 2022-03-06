# Question

Given `n` orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

# Idea

Dynamic Programming

Consider the situation that we have known the possible sequences of the first $i-1$ packages, for the $i$ package:

- delivery(i) and pickup(i) are consecutive, the number of options is $2*(i-1)+1$
- delivery(i) and pickup(i) are not consecutive,  the number of options is $(2i-1)C2$

The sum of them is $i(2i-1)$, so the recurrence formula is $dp[i] = i(2i-1)dp[i-1]$



