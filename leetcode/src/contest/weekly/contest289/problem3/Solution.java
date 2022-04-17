package contest.weekly.contest289.problem3;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-17 19:12
 **/
public class Solution {
    class Pair {
        int twos;
        int fives;

        Pair(int twos, int fives) {
            this.twos = twos;
            this.fives = fives;
        }
    }

    public int maxTrailingZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        Pair[][] h = new Pair[rows + 1][cols + 1];
        Pair[][] v = new Pair[rows + 1][cols + 1];
        for (int i = 0; i <= rows; i++) {
            h[i][0] = new Pair(0, 0);
            v[i][0] = new Pair(0, 0);
        }
        for (int i = 0; i <= cols; i++) {
            h[0][i] = new Pair(0, 0);
            v[0][i] = new Pair(0, 0);
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int[] cur = findTwosAndFivesInNum(grid[i - 1][j - 1]);
                h[i][j] = new Pair(h[i][j - 1].twos + cur[0], h[i][j - 1].fives + cur[1]);
                v[i][j] = new Pair(v[i - 1][j].twos + cur[0], v[i - 1][j].fives + cur[1]);
            }
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                Pair hl2r = h[i][j];
                Pair hr2l = sub(h[i][cols], h[i][j - 1]);
                Pair vt2b = v[i - 1][j];
                Pair vb2t = sub(v[rows][j], v[i][j]);
                List<Integer> list = new ArrayList();
                list.add(Math.min(hl2r.twos + vt2b.twos, hl2r.fives + vt2b.fives));
                list.add(Math.min(hl2r.twos + vb2t.twos, hl2r.fives + vb2t.fives));
                list.add(Math.min(hr2l.twos + vt2b.twos, hr2l.fives + vt2b.fives));
                list.add(Math.min(hr2l.twos + vb2t.twos, hr2l.fives + vb2t.fives));
                for (int k = 0; k < 4; k++) {
                    result = Math.max(result, list.get(k));
                }
            }
        }
        return result;
    }

    private int[] findTwosAndFivesInNum(int val) {
        return new int[]{
                factors(val, 2),
                factors(val, 5)
        };
    }

    int factors(int i, int f) {
        return (i % f != 0) ? 0 : 1 + factors(i / f, f);
    }

    private Pair sub(Pair p1, Pair p2) {
        return new Pair(p1.twos - p2.twos, p1.fives - p2.fives);
    }
}
