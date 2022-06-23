# 0-1 Backpack

NP complete problem - Problems that can not be solve directly - Exaustion - No aftereffect

Backpack problem - It generally refers to the problem of how to maximize the value under the condition that the value and cost are given and the decision rules are limited at the same time.

01 backpack problem refers to how to maximize the total value of the selected items under the specified capacity (limited decision rules) given the value and volume of the items (given value and cost).

`N` items and a backpack of volume `V`, volume of item `i` is `v[i]`, value of item `i` is `w[i]`

Find out which items to load so that the total value is the largest.

```
Input: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
Output: 4
```

Only pick the first item makes the total value the largest.

494: 转化问题以后为0-1背包方案数问题。

416: 转化后为0-1背包可行性问题。

1049: 转化后为0-1背包最小值问题。

## dp N C+1

Design a DFS function to enumerate all situations.

```
int dfs (int[] v, int[] w, int i, int c);
```

`v` and `w` is immutable, `i` refers to the item which is currently enumerated, `c` refers to the remaining volume.

**DP Array**: A two-dimensional array, in which one dimension represents the item currently enumerated, and the other dimension represents the current used capacity. The value of array is the maximum value.

**Status definition**: Consider the first `i` items, the largest total value using capacity less than or equal to `c`.

**State transition equation**: For item `i`, we can choose or not. 

`dp[i][c] = max(dp[i-1][c], dp[i-1][c-v[i]] + w[i])`

```java
class Solution {
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C+1]; // dp[n][c], the maximum total value of first n items using capacity c
        // The first item
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        // The other
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // not choosing
                int n = dp[i-1][j]; 
                // choosing
                // if j < v[i], it's considering the situation that using capacity less than v[i] to accommodate item i, which is impossible
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0; 
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N-1][C];
    }
}
```

## dp 2 C+1

According to the equation, we know that the calculation of a certain row only depends on the previous row. Therefore, an array with only two rows can be used to store the intermediate results. Such a spatial optimization method is called **rolling array**.

```java
class Solution {
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[2][C+1];
        for (int i = 0; i < C + 1; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                int n = dp[(i-1)&1][j]; 
                int y = j >= v[i] ? dp[(i-1)&1][j-v[i]] + w[i] : 0;
                dp[i&1][j] = Math.max(n, y);
            }
        }
        return dp[(N-1)&1][C];
    }
}
```

## dp C+1

Update array in reverse order to compress the original two-dimensional array to one row cause when updating `array[i][c]`, it not only depends on `array[i-1][c]` and a grid on its left side.

```java
class Solution {
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                int n = dp[j]; 
                int y = dp[j-v[i]] + w[i]; 
                dp[j] = Math.max(n, y);
            }
        }
        return dp[C];
    }
}
```

## Problem Conversion



# Complete Backpack

322: 完全背包最小值

279: 完全背包最小值

518: 完全背包方案数

377: 考虑物品顺序的完全背包方案数。每个物品可以重复拿，有几种装满背包的方案？

# Mutiple Backpack

474: 多维费用的 0-1 背包最大值，两个背包大小：0和1的数量

879: 多维费用的 0-1 背包最大值

# Mixed Backpack



# Group Backpack

1155: 每一组是一个骰子，每个骰子只能拿一个体积为1到6的物品

# Multidimensional Backpack