# Question

You have an undirected, connected graph of `n` nodes labeled from `0` to `n - 1`. You are given an array `graph` where `graph[i]` is a list of all the nodes connected with node `i` by an edge.

Return *the length of the shortest path that visits every node*. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

# Thought

Breadth First Search

We should use a queue to store the number of nodes, besides, to make sure that all the nodes are visited, we should record if a node has been visited.

$(u, mask, dist)$ can represent an element in the queue very well, in which $v$ is the number of the node now located, $mask$ is a binary number of length n, bit i represents if i is visited. $dist$ represents the length of path until node $v$

Firstly, put all $(i, 2^i, 0)$ in the queue so that we can start from any node. If $mask == 2^n -1$, we know that every node is visited and we can return $dist$ as an answer.

# Detail

Use a hashmap to record if $(u, mask)$ is visited.

