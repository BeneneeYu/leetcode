# Question

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

# Idea

1. Sort the array to reduce repetition.
2. For each iteration, the elements of two adjacent enumerations cannot be the same.(Notice that the solution set must not contain duplicate triplets.)
3. For $a+b+c=0$ and $a + b' + c' = 0$, if $b' > b$, $c' < c$. So that the direction of two pointers are opposite.

# Solution

```pseudocode
nums.sort()
for first = 0 .. n-1
    if first == 0 or nums[first] != nums[first-1] then
        // 第三重循环对应的指针
        third = n-1
        for second = first+1 .. n-1
            if second == first+1 or nums[second] != nums[second-1] then
                // 向左移动指针，直到 a+b+c 不大于 0
                while nums[first]+nums[second]+nums[third] > 0
                    third = third-1
                // 判断是否有 a+b+c==0
                check(first, second, third)
```

