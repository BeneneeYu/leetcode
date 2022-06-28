# Question

Given an `n x n` binary matrix `grid`, return *the length of the shortest **clear path** in the matrix*. If there is no clear path, return `-1`.

A **clear path** in a binary matrix is a path from the **top-left** cell (i.e., `(0, 0)`) to the **bottom-right** cell (i.e., `(n - 1, n - 1)`) such that:

- All the visited cells of the path are `0`.
- All the adjacent cells of the path are **8-directionally** connected (i.e., they are different and they share an edge or a corner).

The **length of a clear path** is the number of visited cells of this path.

# Idea

Use a queue, add all the adjacent grids and maintain the distance, if we reach the end point, return the distance.

It's unnecessary to deep copy grid because when we revisit a grid that is identified as `1`, we know that there is a path with less steps to reach. So that we can skip this situation.