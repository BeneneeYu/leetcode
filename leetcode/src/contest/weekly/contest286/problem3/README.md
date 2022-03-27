# Question

Given an integer array `queries` and a **positive** integer `intLength`, return *an array* `answer` *where* `answer[i]` *is either the* `queries[i]th` *smallest **positive palindrome** of length* `intLength` *or* `-1` *if no such palindrome exists*.

A **palindrome** is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.

**Example 1:**

```
Input: queries = [1,2,3,4,5,90], intLength = 3
Output: [101,111,121,131,141,999]
Explanation:
The first few palindromes of length 3 are:
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 201, ...
The 90th palindrome of length 3 is 999.
```

**Example 2:**

```
Input: queries = [2,4,6], intLength = 4
Output: [1111,1331,1551]
Explanation:
The first six palindromes of length 4 are:
1001, 1111, 1221, 1331, 1441, and 1551.
```

**Constraints:**

- `1 <= queries.length <= 5 * 104`
- `1 <= queries[i] <= 109`
- `1 <= intLength <= 15`

# Ideas

We only need to look at the first half of the digits (rounding up if there are an odd number of digits), which are significant digits.

We just need to come up with an algorithm to generate the nth valid significant digits. This would be easier if we allowed for leading zeros, so we'll come up with the algorithm that allows for leading zeros, then tweak the algorithm.

# Example

Find the 113th palindrome of length 9.

Determine number of digits to look at: Round up(9 / 2) = 5 --> only look at first 5 digits.

Find number to add to get rid of leading zeros: 10^(5-1) = 10000

Use formula: (113 - 1) + 10000 = 10112

Expanded into palindrome: 101121101