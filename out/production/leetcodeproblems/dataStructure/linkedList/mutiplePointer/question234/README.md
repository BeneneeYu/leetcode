# Question

Given the `head` of a singly linked list, return `true` if it is a palindrome.

# Solution

## Copy Array

Copy list nodes to array and use double pointers. The implementation is obvious.

## Recursion

For example,

```javascript
function print_values_in_reverse(ListNode head)
    if head is NOT null
        print_values_in_reverse(head.next)
        print head.val
```

Use recursion to do traversal from reverse and use parameters besides those in function parameters.

```java
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
```

## Double Pointers

To avoid using extra `O(n)` space, we can change the input.

We can reverse the second half of the list and compare, after which it's always better to recover.

This method does not apply to concurrent modifications.

### Algorithm

1. Find the tail node of the first half list.
2. Reverse the second half list.
3. Judge.
4. Restore the list.
5. Return the result.

Use double pointers to find the mid node.