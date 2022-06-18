# Question

Given a string `s` and a dictionary of strings `wordDict`, add spaces in `s` to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in **any order**.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.

# Idea

For "catsanddog",

- "c" is not a word
- "ca" is not a word
- "cat" is a word, recursive partitioning "sanddog"
- "cats" is a word, recursive partitioning "anddog"
- ...

A pointer scans from left to right,

- If the substring on the left side of pointer is a word, recursive partitioning the remaining substring
- If not, break recursion, backtrack and consider other branches



## Terminate Condition

When the pointer is out of index because no new word can be splited.





## Memorialization

To avoid a lot of duplicate calculations, use map to store the calculation results. The array index is the pointer position, and the value is the result of the sub call. The next time you encounter the same sub problem, you can directly return the cached value in memo instead of falling into repeated recursion.

# Solution

- `List<String> dfs(int start)`: From index start, split the string and return the result