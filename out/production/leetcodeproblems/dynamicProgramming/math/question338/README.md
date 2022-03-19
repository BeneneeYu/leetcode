# Question

Given an integer `n`, return *an array* `ans` *of length* `n + 1` *such that for each* `i` (`0 <= i <= n`)*,* `ans[i]` *is the **number of*** `1`***'s** in the binary representation of* `i`.

# Lemma

For any integer, $x = x \& (x-1)$ makes the last one turn into zero in binary form of x. 

If $x$ is an integer power of 2, $x \& (x-1) = 0$

# Solution

If we use lemma, the time complexity will be $O(logn)$.

For any positive integer $X$, if the biggest integer $Y$, which is the biggest number, which is smaller or equal to $X$ and is an integer power of 2. It is called the highest valid bit.

The reason why we need to maintain the highest valid bit is that we can make sure  $bits[i] = bits[i - highBit] + 1$

