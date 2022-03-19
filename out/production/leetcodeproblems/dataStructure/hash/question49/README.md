# Problem

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

# **Constraints**

- `1 <= strs.length <= 104`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

# Solution

How to hash? The hash key must be the only way to distinguish or classify two elements.

According to the definition of the anagrams, we can figure out that they are the same in the times of every character appears.

So we can use the times array as the key in the form of string. Link all the lowercase characters and their corresponding appearance times.

# Mistake

When determining the form of key, make it unambiguous.

For example, if we just link the times that every character appear, how to figure out that `01010...00` represents 101 times of b or 10 times of b and 10 times of c?