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

- `==` case should be attributed to `x = mid` case
- `mid = (l + r) / 2` or `(l + r + 1) / 2` depends on `l = mid` or `l = mid + 1`
- always fetch value of `r`

# Template

$[l, mid]$ and $[mid+1, r]$

```java
int bsearch_1(int l, int r)
{
    while (l < r)
    {
        int mid = (l + r)/2;
        if (check(mid)) r = mid;
        else l = mid + 1;
    }
    return l;
}
```

模板2

$[l, mid - 1]$ and $[mid, r]$

```java
int bsearch_2(int l, int r)
{
    while (l < r)
    {
        int mid = ( l + r + 1 ) /2;
        if (check(mid)) l = mid;
        else r = mid - 1;
    }
    return l;
}
```

# Sample

## 33. Search in Rotated Sorted Array

There is an integer array `nums` sorted in ascending order (with **distinct** values).

Prior to being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the possible rotation and an integer `target`, return *the index of* `target` *if it is in* `nums`*, or* `-1` *if it is not in* `nums`.

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

**Example 3:**

```
Input: nums = [1], target = 0
Output: -1
```

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        // find the peak
        int l = 0, r = n - 1;
        while (l < r) {
            // l = mid, so +1
            int mid = l + r + 1 >> 1;
            // in this case, mid can be peak
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // target is in [0, peak]
        if (target >= nums[0]) {
            l = 0;
        } else {
        // [peak+1, n-1]    
            l = l + 1;
            r = n - 1;
        }
        
        // find the first >target number
        while (l < r) {
            int mid = l + r >> 1;
            // in this case, mid can not be target's position
            if (nums[mid] < target) { // can't be <=
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r] == target ? r : -1;
    }
}
```

## 34. Find First and Last Position of Element in Sorted Array

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Example 3:**

```
Input: nums = [], target = 0
Output: [-1,-1]
```



```java
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int l = 0;
        int r = n - 1;
        // find the first number that bigger or equals to target
        while (l < r) {
            int mid = (l + r) / 2;
            // mid can't be a qualified index
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[r] != target) return new int[]{-1, -1};
        int ans1 = r;
        l = 0;
        r = n - 1;
        // find the last number that smaller or equals to target
        // given that target exists, it will find the last number equals to target
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans2 = r;
        return new int[]{ans1, ans2};
    }
```



## 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

```
Input: nums = [1,3,5,6], target = 2
Output: 1
```

```java
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            // in this case, mid can't be the position to place target
            if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
```

