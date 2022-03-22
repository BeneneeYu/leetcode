# Question

In a row of dominoes, `tops[i]` and `bottoms[i]` represent the top and bottom halves of the `ith` domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the `ith` domino, so that `tops[i]` and `bottoms[i]` swap values.

Return the minimum number of rotations so that all the values in `tops` are the same, or all the values in `bottoms` are the same.

If it cannot be done, return `-1`.

# Ideas

For the first dominoes, if the final answer exists, the rest dominoes of the row must contain top[0] or bottom[0]. If not, the answer doesn't exist.

# Algorithm

Do two traversals on the row of dominoes, for the first traversal, if any of the dominoes doesn't hold the value of `top[0]`, return -1.  `top[0]` can be placed in top or bottom of position[0], so we should maintain the number of rotate times to make top[i] or bottom[i] consistent and get the smaller one. 

