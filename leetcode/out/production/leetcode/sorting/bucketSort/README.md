# Core

Bucket sort is based on counting sort and makes use of the mapping in function. The key is to determine the mapping function.

1. Enlarge the number of buckets as long as the extra space is enough.
2. The mapping function can distribute the data in buckets evenly.

# Property

If the input data can be distributed in every single bucket evenly, the efficiency is best. Vice versa.

Elements are scattered in buckets and are sorted in every single bucket.

Complexity is $O(n)$

# Procedure

1. Initialize a two-dimension array to save array of elements array, determine the mapping function.
2. Do traversal and append the element to every bucket array.
3. Sort elements in every bucket array (e.g. insert sort).
4. Collect the data to output the result.