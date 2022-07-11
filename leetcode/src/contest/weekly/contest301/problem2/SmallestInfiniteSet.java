package contest.weekly.contest301.problem2;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-10 10:52
 **/
public class SmallestInfiniteSet {
    boolean[] exist;
    public SmallestInfiniteSet() {
        exist = new boolean[1000]; // exit[i]: i + 1?
        Arrays.fill(exist, true);
    }

    public int popSmallest() {
        for (int i = 0; i < 1000; i++) {
            if (exist[i]){
                exist[i] = false;
                return i + 1;
            }
        }
        return -1;
    }

    public void addBack(int num) {
        exist[num - 1] = true;
    }
}
