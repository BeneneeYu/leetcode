# Question

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

# Ideas

Use binary search twice.

In the first search, we try to find **the first index** that holds the number `target`.

In the second search, we try to find the first index that holds the number that bigger than `target` and subtract `1`.

# Solution

```java
    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return l;
    }
```

This code is designed to find the first index that holds the number `target` among the possible several appearances by making `r = mid - 1` when `nums[mid] >= target`.

Use this function to find the left bound by calling `binarySearch(nums, target)` and get the right bound by calling `binarySearch(nums, target + 1)` and subtract `1` from it. After that, do some verification work, nums[leftBound] must be equal to target.