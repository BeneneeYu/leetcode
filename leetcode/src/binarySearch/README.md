# Case

- Sort an array, or an array is sorted.
- Find an algorithm with less time complexity than $O(n)$ (maybe $O(logn)$)
- Find a split position, elements on the left side of which qualify some conditions, while elements on the right side do not
- Find a maximum/minimum element to satisfy some condition

# Complexity

Time: $O(logn)$

Space: $O(1)$

# Example

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

# Idea

We should make the definition of range clear, it is an invariant.

Four situations:

1. `target < nums[0]`
2. `target == nums[x]`
3. `target is between nums[x] and nums[x+1]`
4. `target > nums[len - 1]`

# Range

```java
    //[left, right]
    public int binarySearchOne(int[] nums, int target) {
        // handle corner case
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        //[start, end]
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    //[left, right)
    public int binarySearchTwo(int[] nums, int target) {
        // handle corner case
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length;

        // [start, end)
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }
```

