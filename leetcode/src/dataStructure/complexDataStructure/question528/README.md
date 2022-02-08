# Problem

You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `ith` index.

You need to implement the function `pickIndex()`, which **randomly** picks an index in the range `[0, w.length - 1]` (**inclusive**) and returns it. The **probability** of picking an index `i` is `w[i] / sum(w)`.

- For example, if `w = [1, 3]`, the probability of picking index `0` is `1 / (1 + 3) = 0.25` (i.e., `25%`), and the probability of picking index `1` is `3 / (1 + 3) = 0.75` (i.e., `75%`).

# Solution

Assume the sum of weight as `total`, we can divide the integers in [1, total] to n parts, which is the length of array w. Part i includes w[i] integers exactly, which can simulate the probability. We select an integer x from [1, total] randomly, if x is included in part i, we return integer i.

Left bound of range(i) is pre(i)-w(i)+1, right bound is pre(i)

where pre[i] is prefix sum from 0 to i

pre(i) is monotonic increasing, so we can use binary search

In binary search, cause `int x = (n + n + 1) / 2` will result in `x = n ` in Java, so we let `low = mid + 1`, or low and mid will be persistent.