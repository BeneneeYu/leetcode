# Problem

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return *the number of islands*.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

# DFS

We can regard the matrix as an undirected graph.

To count the islands, we can scan the two-dimension matrix, if a position is marked as '1', count++ and start depth first search from this position and mark every adjacent '1' as '0' to avoid duplicate count.

The number of islands is the times we find that a position is marked as '1' cause it indicates that it is an individual, unfound island.

# BFS

If a position is marked as '1', add it to the queue and start breadth first search, mark and add to queue while the queue is not empty. Look for the next individual, unfound island after the queue is empty.