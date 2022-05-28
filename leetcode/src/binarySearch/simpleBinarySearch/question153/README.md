# Question

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return *the minimum element of this array*.

# Ideas

After the rotation, we know that `nums[left] > nums[right]`, while `nums[mid]`'s position is not sure.

If the array is not rotated or the right half subarray is sorted from small to large, then the min value is in the left half subarray. Or the min value is in the right half subarray. So we should compare the `nums[mid]` and `nums[right]` so that we can determine the postion range of the min value and decide the direction that boundary contracts.

The invariant in loop should be `left < right`, which means the min value is in `[left, right)`. `Mid` is always closer to `left`, so that `left <= mid` and `mid < right`.

At the end of loop, `nums[left] == nums[mid]` and `left == mid == right - 1`.

If `nums[left] == nums[mid] > nums[right]`, make `left = mid + 1` so that `left == right` to end the loop, and `nums[left] and nums[right]` point at the min value.

If `nums[left] == nums[mid] < nums[right]`, make `right = mid` so that `left == right` to end the loop, and `nums[left] and nums[right]` point at the min value.