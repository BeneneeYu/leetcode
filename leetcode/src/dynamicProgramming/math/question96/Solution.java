package dynamicProgramming.math.question96;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-30 22:49
 **/
public class Solution {
    public int numTrees(int n) {
        // G(n): n consecutive numbers as root nodes, the number of possible BST
        // f(i): the ith number as root, the number of possible BST
        // f(i) = G(i-1)*G(n-i)
        // G(n) = f(1) + ... + f(n) = G(0)*G(n-1)+ ... +G(n-1)*G(0)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            for (int j = 1; j < i + 1; j++)
                dp[i] += dp[j - 1] * dp[i - j];

        return dp[n];
    }
}
