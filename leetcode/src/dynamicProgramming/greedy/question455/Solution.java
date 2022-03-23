package dynamicProgramming.greedy.question455;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * <p>
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * @author: Shen Zhengyu
 * @create: 2022-03-23 14:41
 **/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentCount = 0;
        if (null == s || null == g || 0 == s.length || 0 == g.length) return contentCount;
        Arrays.sort(g);
        Arrays.sort(s);
        int biscuitIndex = 0;
        int childIndex = 0;
        while (childIndex < g.length && biscuitIndex < s.length) {
            if (g[childIndex] <= s[biscuitIndex]) {
                childIndex += 1;
                contentCount += 1;
            }
            biscuitIndex += 1;
        }
        return contentCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 1};

        System.out.println(s.findContentChildren(a, b));
    }
}
