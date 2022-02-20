# Question

Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same.

Return *any possible rearrangement of* `s` *or return* `""` *if not possible*.

# Idea

Consume the characters that appear more frequently as soon as possible. (greedy)

Since the adjacent characters can not be the same, use the two characters `c1` and `c2` that appear the most frequently.

# Solution

According to reasoning, every character can appear at most `(n+1)/2` times. Or the reorganization is impossible.

## PriorityQueue

Maintain a max heap, the comparison is based on the appearance times of characters. Every time we append `c1` and `c2`. After which offer `c1` and `c2` to the heap again if their appearance times are positive.

**Notes**: The appearance times of every characters change with the generation of the result string, and we want to use the characters that appear the most frequently every time. So that using heap makes sense.

## Counting

- Maintain `evenIndex` and `oddIndex`
- If the times of `c`, `0 < times[c] <= n/2 && oddIndex is valid`, put `c` on `newArray[oddIndex]` and `oddIndex += 2`
- If the times of `c`, `c > n/2 || oddIndex is invalid`, put `c` on `newArray[evenIndex]` and `evenIndex += 2` 