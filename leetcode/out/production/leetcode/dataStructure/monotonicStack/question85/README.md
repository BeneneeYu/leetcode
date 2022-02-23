# Question

Given a `rows x cols` binary `matrix` filled with `0`'s and `1`'s, find the largest rectangle containing only `1`'s and return *its area*.

# Thought

The brute force has too much time complexity. We should find a better way.

1. use $left[i][j]$ to record the number of continuous 1 elements on the left side of each element (including itself).
2. For every point in matrix, enumerate the rectangles with all 1 elements and whose right-bottom corner is this point.
3. Cause the max width is decided by the min breadth in the column. We can calculate the maximum area among all rectangles in case 2.
4. This method actually turn input into a series of bar chart, so that we can reuse the monotonic stack in question 84.

Time Complexity and Space Complexity: $O(mn)$

# Solution

Extending from thought, we can use the solution in question 84 as part of our solution.

