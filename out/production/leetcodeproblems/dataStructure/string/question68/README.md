# Question

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the **left** will be **assigned more spaces** than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

**Note:**

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
- The input array `words` contains at least one word.

```
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
```

# Ideas

1. Start a line with the first word `left`, and find an appropriate word `right` as the last word in this line. Method findRight() is to greedily try to go as far right as possible until we fill our current line.
2. After we make sure the words we will use in a line, we can justify the format.
   1. If it's one word, the result is just that word.
   2. If it's the last line then the result is all words separated by a single space.
   3. Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is zero.