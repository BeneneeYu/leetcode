# Question

You are given a string `s`. We want to partition the string into **as many parts as possible** so that **each letter appears in at most one part**.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be `s`.

Return *a list of integers representing the size of these parts*.

# Ideas

Since each letter appears in at most one part, the index of the first appearence of character `c` and the last appearence of character `c` must be included in the same part. So that we should traverse the string and store the last index of every character.

Use greedy algorithm to partition the string into as many parts as possible.

- Traverse the string from left to right, maintain `start` index and `end` index.
- For every character `c`, `end = max(end, endc)`, `endc` is the last index of `c`.
- When we arrive `end`, this is the end of this part, length of which is `end - start + 1`. Make `start = end + 1`.

# Validity

This solution uses greedy algorithm to find the lowest end index of every part. So that the length of every part is shortest. If we choose shorter parts, there must be two letter appearing in the same part twice. According to `end = max(end, endc)`, we make sure that a character can only appear in one part.