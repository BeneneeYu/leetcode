package multiplePointer.slidingWindow.question11;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-05 08:31
 **/
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = calArea(height, left, right);
            res = Math.max(area, res);
            if (height[left] < height[right]) {
                left += 1;
            } else if (height[left] > height[right]) {
                right -= 1;
            } else {
                left += 1;
                right -= 1;
            }
        }
        return res;
    }

    private int calArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
