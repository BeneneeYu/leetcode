# Summary

Implement the operations in O(1) average time complexity

1. insert
2. remove
3. getRandom

HashMap supports O(1) insert and remove, but when it comes to getRandom, we must save values in a list, so that we don't have to convert key set to list in O(n) and can make getRandom in O(1).

# Structure

To make insert and remove operations in O(1) time, we must use hash table.

To return a random element, we must use a container that supports random access, which manage continuous memory.

# Detail

insert is O(1) because we just put value-index to map and add value to list in index

remove is O(1) because we set the element with index to move as the last element and remove the last element

getRandom is O(1) because we get a random int in continuous indexs and return

