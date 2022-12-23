# Question

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

- After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

#  Idea

Store the accumulated maximum profit on every day, three states on every day.

- Hold a stock, the max profit is $f[i][0]$
- Hold no stock, in cooldown, the max profit is $f[i][1]$
- Hold no stock, not in cooldown, the max profit is $f[i][2]$

The final result is $max(f[i-1][0], f[i-1][1], f[i-1][2])$

# States

## State 1

The stock I hold today can be the one we bought, which means I am not in cool down today, or I bought it before today, so I did nothing today.

$f[i][0] = max(f[i-1][0], f[i-1][2]-price[i])$

## State 2

I get in cooldown because I sell the stock today.

$f[i][1] = f[i-1][0] + price[i]$

## State 3

I am not in cooldown because I sold nothing today, I have no stock because I bought nothing today. Yesterday I could be in cooldown or not.

$f[i][2] = max(f[i-1][1], f[i-1][2])$