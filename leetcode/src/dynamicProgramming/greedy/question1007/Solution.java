package dynamicProgramming.greedy.question1007;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-20 08:49
 **/
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotate = check(tops[0], bottoms, tops);
        if (rotate != -1 || tops[0] == bottoms[0]) {
            return rotate;
        } else {
            return check(bottoms[0], bottoms, tops);
        }
    }

    private int check(int x, int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotateA = 0;
        int rotateB = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            } else if (tops[i] != x) {
                rotateA += 1;
            } else if (bottoms[i] != x){
                rotateB += 1;
            }
        }
        return Math.min(rotateA, rotateB);
    }
}
