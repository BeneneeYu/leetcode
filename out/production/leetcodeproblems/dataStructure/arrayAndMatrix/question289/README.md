# Rule

According to [Wikipedia's article](https://en.wikipedia.org/wiki/Conway's_Game_of_Life): "The **Game of Life**, also known simply as **Life**, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an `m x n` grid of cells, where each cell has an initial state: **live** (represented by a `1`) or **dead** (represented by a `0`). Each cell interacts with its [eight neighbors](https://en.wikipedia.org/wiki/Moore_neighborhood) (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the `m x n` grid `board`, return *the next state*.

# Solution

To solve the question in-place, we must expand some composite states to include previous states to contain more information.

Briefly, we can judge by past information contained in composite states but update by now information.

# Algorithm

- Traverse the cells in the `board`
- Calculate the cell states, which will use the composite state that can represent the past state and current state at the same time
- Rule
  - Less than two or more than three living cells around a living cell, the cell dies. Use `-1` to represent that it is alive in the past but dead now.
  - Two or three living cells around a living cell, the cell is still alive. Use `1`.
  - Three living cells around a dead cell, the cell becomes alive. Use `2` to represent that it is dead in the past but alive now.
- Update the board according to new rule.
- Composite states indicate states in the past, so we can update in-place without copying the board.
- To output, eliminate `2` and `-1`.

