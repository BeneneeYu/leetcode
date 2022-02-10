# Structure

To implement **LRU Cache**, we need a HashMap and a DoubleLinkedList.

**LFU Cache** is more complex, it needs two HashMap and several DoubleLinkedList.

The first HashMap is to save the key-value (k-v HashMap), where value represents the Node object, which contains key, value, and frequency. Key is not redundant because sometimes we obtain Node by other means and use its key to do some operations in the k-v hashmap.

The second HashMap is to save the frequency and nodes that have the frequency, the value is a double linked list. 

The two hashmap have the same reference of a node object.

![3.jpg](https://pic.leetcode-cn.com/bb3811c03de13fc8548a01c9ab094f5ed38d7ef9b5f5c6ef82340e222750ae92-3.jpg)

# Operations

## Get

- If k-v map does not contain this key, return -1.
- If k-v map contains required key
  - increase the frequency of node by 1
    - remove it from the n-frequency linked list, add it to the n+1-frequency linked list.
    - remove the n-frequency linkedlist and its key from frequency hashmap if it is null (Or the complexity will not be O(1))

## Put

- If the key exists, modify the value, increase the frequency by 1.
  - Remove the element from i-frequency list, put it to the i+1-frequency list.
  - If the i-frequency list becomes null, remove it from the frequency hashmap.
- If the key does not exist
  - If the size exceeds the capacity, remove the element that has the lowest frequency and add the new element, which has 1 frequency, create the 1-frequency list if the frequency hashmap does not have.
  - If not, add the new element.

We can maintain a variable named **minFreq** to record the least frequency so that we can locate the linked list that has the lowest frequency to delete an element by O(1).

- When do update/retrieve operations, if minFreq no longer exists, we should increase minFreq by one, or make it unchanged.
- When insert, change the minFreq to 1.