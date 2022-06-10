package multiplePointer.range.question391Lint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 * @author: Shen Zhengyu
 * @create: 2022-06-10 12:23
 **/
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        int[] time = new int[1110100]; // stage 1: the change of airplanes number in the sky
        int res = 0;
        int latest = 0;
        for (Interval airplane : airplanes) {
            time[airplane.start] += 1;
            time[airplane.end] -= 1;
            latest = Math.max(latest, airplane.end);
        }
        // stage 2: the total number of airplanes in the sky
        for (int i = 0; i <= latest; i++) {
            if (i != 0) {
                time[i] += time[i - 1];
            }
            res = Math.max(time[i], res);
        }
        return res;
    }

    public int countOfAirplanesByScanning(List<Interval> airplanes) {
        List<int[]> list = new ArrayList<>();
        for (Interval airplane : airplanes) {
            list.add(new int[]{airplane.start, 1});
            list.add(new int[]{airplane.end, -1});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int ans = 0;
        int cnt = 0;
        // with the time advancing
        for (int[] in : list) {
            cnt += in[1];
            if (cnt > ans) {
                ans = cnt;
            }
        }
        return ans;
    }
}
