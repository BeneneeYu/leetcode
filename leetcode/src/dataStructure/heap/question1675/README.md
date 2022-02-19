# Question

You are given an array `nums` of `n` positive integers.

You can perform two types of operations on any element of the array any number of times:

- If the element is **even**, **divide** it by `2`.
  - For example, if the array is `[1,2,3,4]`, then you can do this operation on the last element, and the array will be `[1,2,3,2].`
- If the element is **odd**, **multiply** it by `2`.
  - For example, if the array is `[1,2,3,4]`, then you can do this operation on the first element, and the array will be `[2,2,3,4].`

The **deviation** of the array is the **maximum difference** between any two elements in the array.

Return *the **minimum deviation** the array can have after performing some number of operations.*

# Solution

Perform operations on all the numbers in the array so that every number becomes maximum in its value range.

Then lessen the maximum number until we can not, during when we maintain the answer.

# Reasoning

- If odd number is bigger than even number at first or after operations, after the course of lessening, the deviation is unchanged.
- If odd number is still less than even number after operations, the course of lessening even number can also lessen the deviation. 