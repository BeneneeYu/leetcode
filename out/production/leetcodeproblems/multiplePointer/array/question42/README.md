# Question

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

# Solution

## Dynammic Programming

For index `i`, the maximum height after rain is decided by the smaller one of the maximum height on both side. The amount of water index `i` can hold is the difference of maximum height of `i` and height `i`.

To get the maximum height on both side of index `i` in `O(n)`, use `leftMax` and `rightMax` to represent the maximum height on both side of `i`.

```java
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n]; // leftMax[i]: the maximum height among the left side or index i
        int[] rightMax = new int[n]; // the same
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        // no limit on the right side, only decided by the left side
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // the same
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // the shaded area
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
```

## Monotonic Stack



## Double Pointers

The maximum height after rain is decided by the smaller one of the maximum height on both side. `LeftMax` is calculated from left to right while `rightMax` is calculated from right to left, so we can use two pointers and two parameters to replace of the two arrays.

`holdWater[i] = min(leftMax[i], rightMax[i]) - height[i]` 

For `j > i`,  `jLeftMax >= iLeftMax` and `iRigthMax >= jRightMax`.

If `iLeftMax > jRightMax`，`jLeftMax  >= iLeftMax >= jRightMax`. So we can trap rain water in `j`, which is `jRightMax - height[j]`. Else, ` iRightMax >= iLeftMax`, we can trap rain water in `i`.

Before the two pointers meet,

```java
    public int trapDoublePointer(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int lLeftMax = height[0];
        int rRightMax = height[r];
        while(l < r){
            if (lLeftMax < rRightMax){ // < lRightMax
                ans += lLeftMax - height[l++];
                lLeftMax = Math.max(height[l], lLeftMax);
            }else{ // rLeftMax >= lLeftMax >= rRightMax
                ans += rRightMax - height[r--];
                rRightMax = Math.max(height[r], rRightMax);
            }
        }
        return ans;
    }
```



