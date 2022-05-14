package contest.biweekly.contest78.problem3;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-14 22:30
 **/
public class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = 0;
        int maxLength = 0;
        int res = 0;
        for (int[] tile : tiles) {
            max = Math.max(tile[1], max);
            maxLength = Math.max(tile[1] - tile[0], maxLength);
        }
        if (maxLength >= carpetLen) return carpetLen;
        boolean[] pos = new boolean[max + 1];
        for (int[] tile : tiles) {
            for (int i = tile[0]; i <= tile[1]; i++) {
                pos[i] = true;
            }
        }
        int valid = 0;
        for (int i = 1; i <= carpetLen && i <= max; i++) {
            if (pos[i]) valid += 1;
        }
        if (carpetLen >= max) return valid;
        res = valid;
        for (int i = carpetLen + 1; i <= max; i++) {
            if (pos[i]) valid += 1;
            if (pos[i - carpetLen]) valid -= 1;
            res = Math.max(res, valid);
            if (res >= carpetLen) return carpetLen;
        }
        return res;
    }
}
