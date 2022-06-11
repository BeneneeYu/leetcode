# Question

Given an array `nums` with `n` objects colored red, white, or blue, sort them **[in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

**Follow up**: One-pass algorithm using only constant extra space.

# Idea

Keep the definition valid, and make the loop invariant unchanged in property.

# Solution

Follow-up inspects the subprocess of quick sort, partition, which divide the array into three parts in one pass.

Loop invariant is the unchanged property in the loop process, decided by the problem to solve.

For loop invariant,

- The value can change, but the property remains unchanged
- Property is defined by coder, we can judge whether the statement is true or false
- Loop can be recursion

Different definitions make different original value, operation order and the termination condition.

## Invariant 1

```java
        // [0, zero), [zero, i), [two, len - 1], at first they are null
        int zero = 0;
        int two = len;
        int i = 0;
        // i == two, cover all the array
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero); // move to the front
                zero++; // maintain the property
                i++; // observe the next element
            } else if (nums[i] == 1) {
                i++; // will not affect p0 and p2
            } else {
                two--; 
                swap(nums, i, two);
            }
        }
```

## Invariant 2

```java
        //[0, zero], (zero, i), (two, len - 1]
        int zero = -1;
        int two = len - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++; // after which (zero, i) is valid
            } else if (nums[i] == 1) {
                i++; 
            } else {
                swap(nums, i, two);
                two--;
            }
        }
```

