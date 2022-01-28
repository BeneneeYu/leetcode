package dataStructure.trie.question421;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-27 08:59
 **/
/*
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
1. Find the max depth
2. Pad 0 in front to any number with lower depth (e.g. if max depth = 6, then 3 = 0b000011)
3. Store the left most digit directly under Trie root node, right most digit should be Trie leaf node.
4. Always greedily choose the opposite digit (1 -> 0 or 0 -> 1) if that path exists. It works because we are going from largest digit to smallest.
 */
public class Solution {
    Trie root = new Trie();

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int depth = findMaxDepth(nums);
        for (int i = 1; i < nums.length; i++) {
            addNodeToTrie(nums[i - 1], depth);
            ans = Math.max(ans, check(nums[i], depth));

        }
        return ans;
    }

    public void addNodeToTrie(int num, int depth) {
        Trie cur = root;
        for (int i = depth; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (null == cur.left) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if (null == cur.right) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    public int findMaxDepth(int[] nums) {
        int max = 0;
        int depth = 0;
        for (int n : nums) {
            max = Math.max(n, max);
        }
        while (max > 0) {
            max >>= 1;
            depth++;
        }
        return depth;
    }

    public int check(int num, int depth) {
        Trie cur = root;
        int x = 0;
        for (int k = depth; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }
}