# Question

Given a string s of `'('` , `')'` and lowercase English characters.

Your task is to remove the minimum number of parentheses ( `'('` or `')'`, in any positions ) so that the resulting *parentheses string* is valid and return **any** valid string.

Formally, a *parentheses string* is valid if and only if:

- It is the empty string, contains only lowercase characters, or
- It can be written as `AB` (`A` concatenated with `B`), where `A` and `B` are valid strings, or
- It can be written as `(A)`, where `A` is a valid string.

# Idea

The parentheses is balanced when:

1. The number of `'('` , `')'` are equal.
2. Do traversal on the string and count the number of `'('` and `')'`, there will never be more `')'` than `'('`.

We should make every `')'` match the nearest and unused  `'('`, so that we should know the index of unused `'('`.

# Algorithm

Step:

1. Get the indexs of characters that we should delete.
2. Build a new string.