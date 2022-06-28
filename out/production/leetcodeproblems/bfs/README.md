# Case

- topological sort
- connected group/block
- layer traversal
- shortest path in simple graph
- least steps in transformation from the initial state to the end state

# Template

```Java
ReturnType bfs(Node startNode){
    // must use queue
    Queue<Node> queue = new ArrayDeque<>();
    // HashMap: 1. mark visited nodes 2.record the shortest distance
    // HashSet: connectivity
    HashMap<Node, Integer> distance = new HashMap<>();
    // put all the start nodes to queue and hashmap
    queue.offer(startNode);
    distance.put(startNode, 0);
    
    // while the queue is not empty, poll and extend
    while(!queue.isEmpty()){
        Node node = queue.poll();
        // if necessary
        if (node is terminal point){
            break or return something;
        }
        for (Node neighbor: node.getNeighbors()){
            if (distance.containsKey(neightbor)){
                continue;
            }
            queue.offer(neighbor);
            distance.put(neighbor, distance.get(node) + 1);
        }
    }
    // return distances
    return distance;
    // return connected nodes to start point
    return distance.keySet();
    // return the shortest distance
    return distance.get(endNode);
}
```



```java
List<Node> topologicalSort(List<Node> nodes){
	// count the indegrees of all nodes and put it in map
	Map<Node, Integer> indegrees = getIndegrees(nodes);
	Q
}
```



# BFS or DFS?

- If we want to find out if at least one situation exists, DFS is more efficient because it returns when DFS finds a valid situation. But BFS will try out all the situations, which imports lots of unnecessary paths.
- If we want to find out the shortest path, BFS is more efficient because it tries out all situations, the first to reach is the shortest path.