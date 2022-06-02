# Question

Given an `m x n` binary matrix `mat`, return *the distance of the nearest* `0` *for each cell*.

The distance between two adjacent cells is `1`.

# Idea

For BFS in a graph, the difference between in a tree and it is that

- source can be mutiple points, so that we should offer them **all** to the queue at first
- graph is undirected but tree is directed, so that we should **mark** if a point has been visited yet

The one-cell should be set a value only once to make sure the distance is of the nearest `0`, by marking the one-cell an impossible value at first and only set the value when the value is strange.

# Solution

```java
    Queue<int[]> queue = new LinkedList<>();
    int rows = mat.length;
    int cols = mat[0].length;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (mat[i][j] == 0) {
                queue.offer(new int[]{i, j}); // offer all the qualified source points
            } else {
                mat[i][j] = -1; // mark the unvisited points
            }
        }
    }
    int[] directionX = {-1, 1, 0, 0};
    int[] directionY = {0, 0, -1, 1};
    while (!queue.isEmpty()) {
        int[] pos = queue.poll();
        int thisRow = pos[0];
        int thisCol = pos[1];
        int thisDist = mat[thisRow][thisCol];
        for (int i = 0; i < 4; i++) {
            int newRow = thisRow + directionX[i];
            int newCol = thisCol + directionY[i];
            if (isValid(rows, cols, newRow, newCol) && mat[newRow][newCol] == -1) {
                mat[newRow][newCol] = thisDist + 1; // originate from source points 0-cell
                queue.offer(new int[]{newRow, newCol}); // continue to expand
            }
        }
    }
    return mat;
}
```