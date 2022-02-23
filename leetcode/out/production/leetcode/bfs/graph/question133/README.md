# Question

Given a reference of a node in a **[connected](https://en.wikipedia.org/wiki/Connectivity_(graph_theory)#Connected_graph)** undirected graph.

Return a [**deep copy**](https://en.wikipedia.org/wiki/Object_copying#Deep_copy) (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

**Test case format:**

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with `val == 1`, the second node with `val == 2`, and so on. The graph is represented in the test case using an adjacency list.

**An adjacency list** is a collection of unordered **lists** used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with `val = 1`. You must return the **copy of the given node** as a reference to the cloned graph.

![img](https://assets.leetcode.com/uploads/2019/11/04/133_clone_graph_question.png)

# Details

The solution is to construct a graph with the same structure and the same value of elements, but the nodes can not be the references of nodes in the original graph.

We need to do a traversal on the graph and complete the deep copy in the same time.

To avoid endless loop, we should record the cloned nodes.

# Solution

## DFS

1. Use a hashmap to record every visited node and its deep copy. (Or it will clone recursively and endlessly.)
2. Do the traversal from the given node, if some nodes have been visited, return their deep copy.
3. If some nodes have not been visited yet, create its deep copy and put it in the hashmap.
4. Do traversal on the neighbours of a single node, call function recursively so that every nodes can be created, and add the returned deep copy to the neighbour list of the node.
5. Return the created node.

## BFS

1. Use a hashmap as in DFS. Create a queue to obtain and consume all the nodes.
2. Add the given node to queue, deep copy it and save it to the hashmap.
3. Get a node from the head of the queue every time, do a traversal on its neighbour list. If a single neighbour node is not in the hashmap, deep copy it and save it to hashmap, and add it to the queue, or you can add it to the neighbour list of deep copy (because it's obvious that all nodes in the queue are visited).

