# Question

Given a string array `words`, return *the maximum value of* `length(word[i]) * length(word[j])` *where the two words do not share common letters*. If no such two words exist, return `0`.

```
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
```

# Ideas

To judge if two words share common character, we can use bit manipulation.

For every character in a word, set the `char - 'a'` index of its mask as `1` through or operation so that we can judge from the result of and operation.

```java
masks[i] = (masks[i] | 1 << (words[i].charAt(j) - 'a'));
```

This line of code set the appropriate bit as `1`.