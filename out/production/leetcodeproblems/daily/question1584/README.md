# Question

You are given an array `points` representing integer coordinates of some points on a 2D-plane, where `points[i] = [xi, yi]`.

The cost of connecting two points `[xi, yi]` and `[xj, yj]` is the **manhattan distance** between them: `|xi - xj| + |yi - yj|`, where `|val|` denotes the absolute value of `val`.

Return *the minimum cost to make all points connected.* All points are connected if there is **exactly one** simple path between any two points.

# Idea

We need to connect some points (the connection between any two points will be an edge whose weight is the Manhattan distance between those points) such that all points become connected and the sum of the weights of the chosen edges is minimized.

We can say this problem is a variant of graph problems. More precisely, it is a [Minimum Spanning Tree (MST)](https://leetcode.com/explore/featured/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3884/) problem, where we are given **nodes** (points) and **weighted edges** (distance between two points) and we have to form an MST using them.

> MST problem: Given a connected, weighted, and undirected graph, a minimum spanning tree is a subset of edges that connect all vertices while the total weights of these edges are minimum among all possible subsets.

We can consider our input as a complete graph (each point has an edge to every other point), and in this complete graph, we have to connect each point with minimum cost (sum of edge weights). Thus, we can rephrase the problem as "Find the Minimum Spanning Tree for the given set of points."

Concerning the MST problem, there exist several classic algorithms. In particular, namely [Kruskal's algorithm](https://leetcode.com/explore/featured/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3856/) and [Prim's algorithm](https://leetcode.com/explore/featured/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3859/), which are the most popular ones and feasible to implement during an interview.

# Solution

## Kruskal's algorithm

A greedy algorithm for building a minimum spanning tree in a *weighted* and *undirected* graph.

First, we sort all the edges in increasing order of weight to prioritize adding the lowest-weighted edges first. We will continue to include edges in our MST until all nodes are connected, pay attention to **not including an edge that forms a cycle.**

For this purpose, we can use a disjoint set data structure also called a **union-find** data structure ([disjoint set explore card](https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3881/)).

The union-find data structure has two primary functions:

- `find(a)`: Function which returns the ID of the group in which node `a` belongs.
- `union(a, b)`: Function to merge the groups of node `a` and `b`. If they already belong to the same group, we don't do anything and return `false` to signify the edge between `a` and `b` was not added. Otherwise, we return true.

We will implement union-find by rank with path compression.

So, after sorting all the edges in increasing order, we will try to connect the end nodes of each edge one by one.

First, we need to check if these two nodes are already connected. To do so, we can use the `find` function (because two connected nodes are in the same group). If they are already connected by some other path, then adding this edge will form a cycle; thus, we will omit this edge from the MST. If the nodes are not connected, we can use the `union` function to connect them. We will perform the `find` check inside the `union` function to keep our code clean.

We can make a small optimization here. Instead of iterating over the whole array, when we connect `(n-1)` edges, we can skip the remaining edges because the MST is complete. The MST becomes complete as soon as it contains `(n-1)` edges because **a tree with `n` nodes will always have `(n-1)` edges**.

We will be given coordinate points in our input array, so we will name each point something unique such that working with them is easy. In the union-find data structure, representing each node with an integer will simplify our implementation, so we will represent each point as its index in the input array.

### Algorithm

1. Create a class `UnionFindUnionFind`:
   - `group, rank` - Arrays to store the group (also known as root) and rank of each node.
   - `find(a)` - Function to find the group of node `a` using path compression.
   - `union(a,b)` - Function to merge groups of nodes `a` and `b` by rank.
2. Initialize some variables:
   - `n` - Number of nodes in the graph.
   - `mstCost` - Cost to build the MST.
   - `edgesUsed` - Number of edges included in the MST.
   - `uf` - UnionFind object of size `n` to connect `n` nodes.
   - `allEdges` - Array to store all the edges of our graph.
3. Iterate over all coordinate points, and for each coordinate point, create an edge to all other coordinate points. Store the edges in the `allEdge` array. Each element of `allEdges` contains three values: **edge weight, node1, node2**.
4. Sort the elements in `allEdges` in increasing order of their edge weights.
5. Iterate over each edge in `allEdges` until `edgesUsed` becomes equal to `n-1`. For each edge:
   - Try joining both the nodes of the current edge.
   - If the nodes are already connected, we discard the current edge because including this edge would create a cycle. Otherwise, we add the weight of the current edge to the `mstCost` variable and increment `edgesUsed` by `1`.
6. Return the total cost of MST, `mstCost`.

## Prim's Algorithm

It is also a greedy algorithm for building a minimum spanning tree in a *weighted* and *undirected* graph.

In this algorithm, we include an arbitrary node in the MST and keep on adding the **lowest-weighted** edges of the nodes present in the MST until all nodes are included in the MST and **no cycles** are formed.

In this algorithm, we can pick any node to start with. Then we will choose the **lowest-weighted edge** that connects **a node present in the MST to a node not present in the MST**. We could keep all of the edges in an array and then sort them. But then, for each new node that we add to the MST, we would have to add the new node's edges to the array and sort the array again. This would be a costly operation when done repeatedly.

A more efficient way to track which edges are available and which of these edges has the lowest weight is to use a [min-heap data structure](https://leetcode.com/explore/featured/card/heap/). A **min-heap** is a tree-like data structure that always stores the minimum valued element (edge weight here) at the root and where insertion and removal of elements (edges) take logarithmic time.

Now, we know how to greedily pick the lowest-weighted edge, but **how can we check if including an edge will form a cycle in the MST?**
Consider the example below. We can say, for the node `0` of the MST there exists an edge that is greedily best to choose and it connects to node `4`. If node `4` is already present in the MST it means there already exists a path from node `0` to `4` and hence adding this edge would form a loop.

Thus, we can use one boolean array to record which nodes are already present in the MST. If both of an edge's nodes are already present in the MST, we will discard the edge. Otherwise, we will include this edge and mark the newly added node as present in the MST.

Since an MST can only have `n−1` edges, we can use it as an early exit condition to stop iterating over heap elements.

### Algorithm

1. Initialize some variables:
   - `n` - Number of nodes of the graph.
   - `mstCost` - Cost to build the MST.
   - `edgesUsed` - Number of edges included in the MST.
   - `inMST` - Array to track if a node was already included in MST or not.
   - `heap` - A min-heap to pick minimum weight edge, each element of heap is a pair of `(edge \space weight, \space node)(edge weight, node)`.
2. Initially, we start with node `0` and the cost to include this node will be `0`, thus we push all adjacent edges of node `0` in `heap` with their respective `weights` using a for-loop. However, to make the code implementation cleaner, we will simply initialize the `heap` with the pair `(0, 0)`, which represents a temporary edge to node `0` with a weight of `0`.
3. We pop elements from the `heap` and attempt to add them to the tree until `edgesUsed` becomes equal to `n`. We initially added one temporary edge, thus we stop when `n` edges are added in the MST.
   - We get the minimum weighted edge and the node from the top of `heap` and pop it.
   - If this node is already present in our MST `(inMST[node]==true)` we discard this edge.
   - Otherwise, we include this node in our MST, increment `edgesUsed` by `1`, add the edge's weight to the `mstCost`, and push the edges of this node into the `heap`.
4. We return the total cost of MST.

