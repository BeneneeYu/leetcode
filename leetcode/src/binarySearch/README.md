# Scene

An input array is sorted.

The solution should be $O(logn)$ in time complexity.

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

## left closed, right closed

We assume that the target is in [left, right], while left <= right, the range is valid.

l = 0, r = len - 1

```Java
while (left <= right) {
	int middle = (left + right)/2;
	if (nums[middle] > target) {
		right = middle - 1; // target in [left, middle - 1]
	} else if (nums[middle] < target) {
		left = middle + 1; // target in [middle + 1, right]
	} else { // nums[middle] == target
		return middle;
	}
}
	return right + 1;
```

## left closed, right open

l = 0, r = len

```java
while (left < right) {
	int middle = (left + right)/2;
	if (nums[middle] > target) {
		right = middle; // target in [left, middle)
	} else if (nums[middle] < target) {
		left = middle + 1; // target in [middle + 1, right)
	} else { // nums[middle] == target
		return middle;
	}
}
	return right;
```

