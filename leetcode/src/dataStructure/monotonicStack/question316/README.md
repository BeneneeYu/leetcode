# Problem

Given a string `s`, remove duplicate letters so that every letter appears once and only once. You must make sure your result is **the smallest in lexicographical order** among all possible results.

# Ideas

Normally, to get the string which is the smallest in lexicographical order, we try to find the first `i`, which makes `s[i]>s[i+1]` in lexicographical order. And we remove `s[i]`. For example, `abcba`, we remove `c` so that we can get `abba`, which is the smallest in lexicographical order. We call `c` as key character.

To remove all the key characters, we can scan the whole string. But we must handle lots of temp strings because the string changes with the removal.

To optimize the process, we can scan the string from front to the end. We can use a monotonic stack to maintain the string after the removal of key characters. In the stack, the character is ascending from bottom.

If the peek character of stack is bigger than `s[i]`, we should pop it.

To cater to the question,

- If `s[i]` is already in the stack, we can not add `s[i]`.
- When we want to pop, if the remaining string doesn't have such a character, we can not pop. So that we should record the left numbers of every character.



