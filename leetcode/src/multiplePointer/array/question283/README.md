# Question

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note** that you must do this in-place without making a copy of the array.

# Ideas

The left pointer points at the tail of handled sequence, the right pointer points at the head of sequence awaiting handling.

Integers on the left side of left pointer are non-zero, integers between the left pointer and the right pointer are zero.

Every step we make right pointer move, while only if we handled a non-zero number, we swap and make left pointer move.