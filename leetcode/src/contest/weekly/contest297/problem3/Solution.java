package contest.weekly.contest297.problem3;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the cookies in the same bag must go to the same child and cannot be split up.
 * <p>
 * The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
 * <p>
 * Return the minimum unfairness of all distributions.
 * @author: Shen Zhengyu
 * @create: 2022-06-12 10:25
 **/
public class Solution {
    int res = Integer.MAX_VALUE;

    // k children
    public int distributeCookies(int[] cookies, int k) {
        dfs(cookies, 0, k, new int[k]);
        return res;
    }

    private void dfs(int[] cookies, int cur, int k, int[] children) {
        if (cur == cookies.length) {
            System.out.println(Arrays.toString(children));
            int max = Integer.MIN_VALUE;
            for (int child : children) {
                max = Math.max(max, child);
            }
            res = Math.min(res, max);
            return;
        }

        // this bag of cookies, try to assign to every one
        for (int i = 0; i < k; i++) {
            children[i] += cookies[cur];
            System.out.println(i + ":" + Arrays.toString(children));
            dfs(cookies, cur + 1, k, children);
            children[i] -= cookies[cur];
        }
    }

    /* [8,15,10] 2
0:[8, 0]
0:[23, 0]
0:[33, 0]
1:[23, 10]
1:[8, 15]
// 15 assigned to child 2, 10 assigned 2 cases
0:[18, 15]
1:[8, 25]
1:[0, 8]
0:[15, 8]
0:[25, 8]
1:[15, 18]
1:[0, 23]
0:[10, 23]
1:[0, 33]
     */
}
