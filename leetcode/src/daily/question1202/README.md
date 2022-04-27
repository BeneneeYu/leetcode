# Question

You are given a string `s`, and an array of pairs of indices in the string `pairs` where `pairs[i] = [a, b]` indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given `pairs` **any number of times**.

Return the lexicographically smallest string that `s` can be changed to after using the swaps.

# Idea

We can break the solution down into four steps: build a graph using the given pairs, find the connected components in the graph, sort the characters in each connected component in ascending order, and build the smallest string. It's challenging to find out which indices belong to the same connected component.

DFS, BFS, and Union-Find are each commonly used to find connected components.

# Solution

We will build the adjacency list using the pairs given i.e., for each pair `(x, y)` we will add an edge from `x` to `y` and from `y` to `x`. Then we will iterate over the indices from `0` to `n-1` where `n` is the length of the given string `s`. For each index, if it has not been visited yet, we will perform a DFS and store the vertices (index) and the characters at these indices in a list. Each list will represent a different component in the graph. Then we will sort each list of indices and each list of characters and place the ith character at the ith index in the string `smallestString`.

1. Iterate over the `pairs` and create an adjacency list such that `adj[source]` contains all the adjacent vertices of vertex `source`.
2. Iterate over the indices from 0 to s.size() - 1. For each index `vertex` we will:
   - Perform DFS if `vertex` is not visited yet (visited[vertex] is false)
     - While performing DFS, store `vertex` in the list `indices` and the character `s[vertex]` in the list `characters`.
   - Sort the lists `indices` and `characters`.
   - Iterate over `indices` and `characters`, and place the i_{th}*i**t**h* character at the i_{th}*i**t**h* index in the string `smallestString`.
3. Return `smallestString`.