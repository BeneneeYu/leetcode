package multiplePointer.array.question42;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-10 18:36
 **/
public class Solution {
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

    public int trapMonotonicStack(int[] height) {
        return 1;
    }

    public int trapDoublePointer(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int lLeftMax = height[0];
        int rRightMax = height[r];
        while (l < r) {
            if (lLeftMax < rRightMax) { // < lRightMax
                ans += lLeftMax - height[l++];
                lLeftMax = Math.max(height[l], lLeftMax);
            } else { // rLeftMax >= lLeftMax >= rRightMax
                ans += rRightMax - height[r--];
                rRightMax = Math.max(height[r], rRightMax);
            }
        }
        return ans;
    }
}
