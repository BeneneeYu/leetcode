# Question

There is an **undirected** graph with `n` nodes, where each node is numbered between `0` and `n - 1`. You are given a 2D array `graph`, where `graph[u]` is an array of nodes that node `u` is adjacent to. More formally, for each `v` in `graph[u]`, there is an undirected edge between node `u` and node `v`. The graph has the following properties:

- There are no self-edges (`graph[u]` does not contain `u`).
- There are no parallel edges (`graph[u]` does not contain duplicate values).
- If `v` is in `graph[u]`, then `u` is in `graph[v]` (the graph is undirected).
- The graph may not be connected, meaning there may be two nodes `u` and `v` such that there is no path between them.

A graph is **bipartite** if the nodes can be partitioned into two independent sets `A` and `B` such that **every** edge in the graph connects a node in set `A` and a node in set `B`.

Return `true` *if and only if it is **bipartite***.

# Idea

To summarize, for any two nodes `u` and `v` in the graph, if there is an edge between them, `u` and `v` can not be contained in the same set.

Select a node and start traversal, mark its connected nodes as a different color, which means they can not belong to the same set because they have an edge between them.

After the traversal, if all the nodes are marked, we can conclude it as a bipartite graph. If some nodes are not marked, which shows that we want to mark a node as a kind of color but it has been already marked as another color, it is not bipartite. 

# Solution

- Choose any node to start, mark it as red, start the traversal from this node.
- In the process, if we visit `v` through `u`, which means there is an edge between `u` and `v` in the graph.
  - If `v` has been marked and it has the same color with `u`, the graph is not bipartite. We can break the loop and return false.
  - If `v` has not been marked, mark it as a different color from `u`'s, and do traversal on the nodes that are connected with `v`. 