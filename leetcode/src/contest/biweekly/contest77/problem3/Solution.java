package contest.biweekly.contest77.problem3;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-30 22:29
 **/
public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map = new int[m][n];
        // unprotected = 0;
        // protected = 1;
        // guards = 2;
        // walls = 3;
        int res = 0;
        for (int[] guard : guards) {
            fill(map, 2, guard[0], guard[1]);
        }
        for (int[] wall : walls) {
            fill(map, 3, wall[0], wall[1]);
        }
        for (int[] guard : guards) {
//            System.out.println(Arrays.toString(guard));
            int guardX = guard[0];
            int guardY = guard[1];
            int x = guardX;
            int y = guardY;
            if (x < m - 1){
                x += 1;
                while (x < m && map[x][guardY] < 2){
                    map[x][guardY] = 1;
                    x++;
                }
            }
            x = guardX;
            if (x > 0){
                x -= 1;
                while (x >= 0 && map[x][guardY] < 2){
                    map[x][guardY] = 1;
                    x--;
                }
            }
            if (y < n - 1){
                y += 1;
                while (y < n && map[guardX][y] < 2){
                    map[guardX][y] = 1;
                    y++;
                }
            }
            y = guardY;
            if (y > 0){
                y -= 1;
                while (y >= 0 && map[guardX][y] < 2){
                    map[guardX][y] = 1;
                    y--;
                }
            }
        }
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) res += 1;
            }
        }
        return res;
    }
    private void fill(int[][] map, int value, int x, int y){
        map[x][y] = value;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
    }
}
