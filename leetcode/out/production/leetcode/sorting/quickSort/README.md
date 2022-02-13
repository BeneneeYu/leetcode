# Property

Worst time complexity: $O(n^2)$

Average time complexity: $O(nlogn)$

# Procedure

1. Select an element (for example the leftmost element) from an array, name it as `pivot`.
2. Sort the array so that all elements that smaller than `pivot` are placed before it, while all elements that bigger than `pivot` are placed after it. This procedure is called `partition`.
3. Sort the subarray that contains all smaller elements  and the subarray that contains all bigger elements recursively.



