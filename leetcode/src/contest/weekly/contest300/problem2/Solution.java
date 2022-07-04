package contest.weekly.contest300.problem2;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-03 10:17
 **/
public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int toAdd = m * n;
        int added = 0;
        ListNode node = head;
        while (added < toAdd) {
            for (int i = left; i <= right && added < toAdd; i++) {
                int toAddNum = null == node ? -1 : node.val;
                res[top][i] = toAddNum;
                added += 1;
                node = null == node ? null : node.next;
            }
            top += 1;
            for (int j = top; j <= bottom && added < toAdd; j++) {
                int toAddNum = null == node ? -1 : node.val;
                res[j][right] = toAddNum;
                added += 1;
                node = null == node ? null : node.next;
            }
            right -= 1;
            for (int i = right; i >= left && added < toAdd; i--) {
                int toAddNum = null == node ? -1 : node.val;
                res[bottom][i] = toAddNum;
                added += 1;
                node = null == node ? null : node.next;
            }
            bottom -= 1;
            for (int j = bottom; j >= top && added < toAdd; j--) {
                int toAddNum = null == node ? -1 : node.val;
                res[j][left] = toAddNum;
                added += 1;
                node = null == node ? null : node.next;
            }
            left += 1;
        }
        return res;
    }
}
