package contest.biweekly.contest78.problem3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-14 23:06
 **/
public class Solution2 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int maxLength = 0;
        for (int i = 0; i < tiles.length; i++) {
            int[] tile = tiles[i];
            int thisLength = tile[1] - tile[0] + 1;
            if (thisLength >= carpetLen) return carpetLen;
            maxLength = Math.max(maxLength, thisLength);
        }
        return maxLength;
    }
}
