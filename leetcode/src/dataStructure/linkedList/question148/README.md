# Question

Given the `head` of a linked list, return *the list after sorting it in **ascending order***.

**Follow up:** Can you sort the linked list in `O(n logn)` time and `O(1)` memory (i.e. constant space)?

# Ideas

Sorting algorithms with `O(nlogn)` time complexity include merge sort, heap sort and quick sort (worst case `O(n^2)`). The best algorithm for linked list is merge sort.

The base of merge sort is divide and conquer. Top-down recursion is an easy way to  implement with `O(logn)` space complexity. While bottom-up algorithm is with `O(1)` space complexity.

# Solution

## Top-down Merge Sort

1. Find the mid of linked list as pivot (double pointers), split the list into two sub lists.
2. Sort the two sub lists separately.
3. Merge the two sorted sub lists.

The termination condition of recursion is the number of nodes in list is less than or equal to one, when the list can no

## Bottom-up Merge Sort

