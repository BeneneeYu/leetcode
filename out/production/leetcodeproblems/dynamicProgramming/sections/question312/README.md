# Question

You are given `n` balloons, indexed from `0` to `n - 1`. Each balloon is painted with a number on it represented by an array `nums`. You are asked to burst all the balloons.

If you burst the `ith` balloon, you will get `nums[i - 1] * nums[i] * nums[i + 1]` coins. If `i - 1` or `i + 1` goes out of bounds of the array, then treat it as if there is a balloon with a `1` painted on it.

Return *the maximum coins you can collect by bursting the balloons wisely*.

# Idea

Reverse these operations, and think of the whole process as adding one balloon at a time.

solve(i, j) returns the maximum coin number we can obtain by filling in all positions in (i,j)

When i < j - 1, enumerate all positions in (i,j) `mid`, let `mid` be the first ballon to add, recursively calculate the contribution of two intervals, max value is return value of solve(i,j)

In order to prevent duplicate calculating, we store the results and use cache to optimize the time complexity
