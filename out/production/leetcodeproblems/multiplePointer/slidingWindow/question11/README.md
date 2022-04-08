# Question

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return *the maximum amount of water a container can store*.

**Notice** that you may not slant the container.

# Ideas

We use double pointers, initialized as the head and tail of the array.

The amount of water it can contains is decided by `min(x,y)*t`, t is the distance. We should move the pointer with less height because it will never be the lines of the container because `t` and `min(x,y)` can only decrease when we move the other pointer. We can throw the position.



