# Question

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

- `'.'` Matches any single character.
- `'*'` Matches zero or more of the preceding element.

The matching should cover the **entire** input string (not partial).

# Idea

When a star is present, we may need to check many different suffixes of the text and see if they match the rest of the pattern. A recursive solution is a straightforward way to represent this relationship.

As the problem has an **optimal substructure**, it is natural to cache intermediate results. We ask the question $dp(i, j)$: does $text[i:]$ and $pattern[j:]$ match? We can describe our answer in terms of answers to questions involving smaller strings.