# Question

You are given an integer array `nums` and an integer `target`.

You want to build an **expression** out of nums by adding one of the symbols `'+'` and `'-'` before each integer in nums and then concatenate all the integers.

- For example, if `nums = [2, 1]`, you can add a `'+'` before `2` and a `'-'` before `1` and concatenate them to build the expression `"+2-1"`.

Return the number of different **expressions** that you can build, which evaluates to `target`.

# Idea

## backtrack

Traverse all different expressions.

time complexity: $O(2^n)$

## dp

Elements in `nums` are positive, `sum` is the sum of nums elements, `neg` is the sum of elements added `-`(neg>0), we know that `(sum - neg) - neg = target`, so that `neg = (sum - target) / 2`

When `sum - target < 0`, we can break the loop and return 0.

The problem now is to select some elements in `nums` so that the sum of them is `neg`.

`dp[i][j]` represents the number of solutions to select elements from the first i numbers of array `nums` so that the sum of these elements is equal to `j`.

The result of the original problem is `dp[n][neg]`. (Number of means to select n numbers in `nums`, sum of which is `neg`)

`dp[0][j] = 0, except for dp[0][0] == 1`

When `1 <= i <= n`, for nums[i], num, traverse 0 to neg, calculate `dp[i][j]`

- If `j < num`, we can not choose num, `dp[i][j] = dp[i-1][j]`
- If `j >= num`, we can choose num or not, `dp[i][j] = dp[i-1][j] + dp[i-1][j-num]`