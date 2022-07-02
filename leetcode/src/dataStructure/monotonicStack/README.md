# Introduction

Monotonic Stack is a special variation of the typical data structure Stack, its elements are all monotonic decreasing or increasing. If we need to pop **smaller** elements from the stack before pushing a new element, the stack is **decreasing** from bottom to top.

Otherwise, it's **increasing** from bottom to top.

For example,

```
Mono-decreasing Stack

Before: [5,4,2,1]
To push 3, we need to pop smaller (or equal) elements first
After: [5,4,3]
```

- we need to pop **smaller** elements before pushing.
- it keep tightening the result as lexigraphically **greater** as possible. (Because we keep popping smaller elements out and keep greater elements).

# When to Use Monotonic Stack

Monotonic Stack is the best time complexity solution for many “*range queries in an array”* problems. Because every element in the array could only enter the monotonic stack once, the time complexity is O(N). (N represents the length of the array).

For every “range query” problem, it could be sure to maintain a range using a normal array/list. However, we will do many repetitive operations to get information from every range. The time complexity is very high and the solution is always not good.

Using monotonic stack to maintain a range can save lots of time. Because it only updates information within the range based on new adding elements and avoids repetitive operations of existing elements. To be more precisely, the monotonic stack helps us maintain maximum and and minimum elements in the range and keeps the order of elements in the range. Therefore, we don’t need to compare elements one by one again to get minima and maxima in the range. At mean while, because it keeps the elements’ order, we only need to update the stack based on newest adding element.

The concept of monotonic stack, which is just a stack keeping monotonic, is not difficult to understand. But the hardest part is how to use this data structure to model and solve problems. Sometime it’s not obvious which solution is best for a problem if you are not familiar with many techniques and example problems. If a problem is suitable to use monotonic stack, it must has at least three characters:

1. **It is a “range queries in an array” problem.**
2. **The minima/maxima element or the monotonic order of elements in a range is useful to get answer of every range query.**
3. **When a element is popped from the monotonic stack, it will never be used again.**

# Question402

Given string num representing a non-negative integer `num`, and an integer `k`, return *the smallest possible integer after removing* `k` *digits from* `num`.

1. Find a range that constructs the minimum lexicographic order integer
2. every query, remove 0 to stack size elements to construct the answer
3. when the bigger and ahead character is removed, it should never be used again