# Question

You are given an array of integers `stones` where `stones[i]` is the weight of the `ith` stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:

- If `x == y`, both stones are destroyed, and
- If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.

At the end of the game, there is **at most one** stone left.

Return *the smallest possible weight of the left stone*. If there are no stones left, return `0`.

**Example 1:**

```
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
```

# Idea

After several times of smashing, the weight of the left stone is  $\sum k_i*stones_i$, $k_i\in \{-1,1\}$.

=> Divided the stones into two piles, one pile is of `ki == -1`, the other pile is of `ki == 1`,

=> To make the smallest weight of left stone, the difference `diff` between the absolute value of the sum of two piles of stones should be the smallest.

=> The sum of weight of `ki == -1` is neg, $sum - neg - neg = \sum k_i*stones_i$, neg should be as large as possible, but less than [sum/2].

=> That's a problem of capacity = sum / 2, value and volume is stones_i to choose i stones so that the sum of weight is the closest to half of total weight.





