# Question

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.

# Idea

## DFS

If valid currently, continue to try.

Use a pointer to scan the string from left to right,

- If the left side of pointer is word, examine the remaining substring in recursion
- If it isn't, backtrack and examine other branches

a branch is slicing in a given position

#### Memorialization

```
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab,["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
```

To avoid duplicate calculations, use an array to save the result of sub problem. Every sub problem is solved at most once.

## BFS

Try out all the situations in this level, just enqueue the possible solutions and try it in next level.

Maintain a queue,

1. Firstly, offer pointer `0` to the queue and cut out prefix substring with `0` and any other indexes.
2. If substring(0, i) is a word, offer `i` to the queue and examine the remaining substring starting with i.
3. Repeatedly poll and offer, until the pointer is out of index, no remaining substring and no pointer to offer. If the prefix string is a word, return true.
4. If the whole BFS process never returns true, return false.

### Optimization

Use an array to record the visited nodes. When a pointer is dequeued, skip if there are duplicates. (because when it is visited, if it is true, the result has been returned, if not, it's unnecessary to visit it)

## DP

