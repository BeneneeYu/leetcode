# Core

Convert the input data to keys and save them in arrays. The time complexity is $O(n)$, which requires that the input data should be integers in determined range.

# Property

The needed time and space increase with the expanding data range. A better solution is radix sort.

# Procedure

1. Find the biggest and smallest elements in an unsorted array.
2. Count the times of every element i appears, save it to the `array[i]`
3. Place every element `i` `array[i]` times in array.

