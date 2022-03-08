# Question

Given an array of non-negative integers `nums`, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

# Ideas

Greedy Algorithm

## Brute Force

Search starting position from tail, select the position with lowest index where we can reach the tail from this position. And mark it as the new tail.

Time complexity: $O(n^2)$

## Forward Direction

We maintain the position with largest index we can reach, call it border line. Traverse the array from forward direction, when we reach the border line, update it and add the jump times by one.

Time complexity: $O(n)$

