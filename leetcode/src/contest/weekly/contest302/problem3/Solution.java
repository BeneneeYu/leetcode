package contest.weekly.contest302.problem3;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-17 10:41
 **/
public class Solution {
    class MyString implements Comparable {
        int index;
        public String s;

        MyString(int in, String ss) {
            index = in;
            s = ss;
        }


        @Override
        public int compareTo(Object o) {
            MyString ms = (MyString) o;
            return ifFormerStringBigger(ms.s, this.s);
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int strLen = nums[0].length();
        HashMap<Integer, ArrayList<MyString>> trimmedResult = new HashMap<>();
        int times = queries.length;
        int[] result = new int[times];
        for (int i = 0; i < times; i++) {
            int trimmed = queries[i][1];
            int kth = queries[i][0];
            if (!trimmedResult.containsKey(trimmed)) {
                ArrayList<MyString> list = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    list.add(new MyString(j, nums[j].substring(strLen - trimmed, strLen)));
                }
                Collections.sort(list);
                trimmedResult.put(trimmed, list);
                result[i] = list.get(kth - 1).index;
            } else {
                ArrayList<int[]> list = new ArrayList<>();
                result[i] = trimmedResult.get(trimmed).get(kth - 1).index;
            }
        }
        return result;
    }

    private int ifFormerStringBigger(String s1, String s2) {
        s1 = cutLeadingZero(s1);
        s2 = cutLeadingZero(s2);
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return -1;
        } else if (len1 < len2) {
            return 1;
        }
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    private String cutLeadingZero(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.charAt(0) == '0' && sb.length() != 1) sb.deleteCharAt(0);
        return sb.toString();
    }
}
/*
["64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"]
[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]
 */