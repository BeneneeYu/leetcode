# Question

Given an integer array `nums`, you need to find one **continuous subarray** that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return *the shortest such subarray and output its length*.

# Idea

The elements that bigger than and on the left side of the minimum element should be sorted.

The elements that smaller than and on the right side of the maximum element should be sorted.

# Solution

Divide `nums` as `numsA`, `numsB` and `numsC`, `numsB` is the requested subarray. So that we don't need to change `numsA` and `numsC` and any number in `numsB` and `numsC` is bigger than the biggest number in `numsA`.

Scan once.

If `nums[i]` is smaller than the maximum number that used to appear in previous subarray, it should be included and expand to the right side.

If `nums[i]` is bigger than the minimum number that used to appear in subsequent array, it should be included and expand to the left side.