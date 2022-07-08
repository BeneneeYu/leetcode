package dfs.backtrack.question93;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-06 16:19
 **/
public class Solution {
    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return res;
        List<String> subIPs = new ArrayList<>();
        dfs(s, subIPs, 0);
        return res;
    }

    private void dfs(String s, List<String> subIPs, int lastSplit) {
        if (subIPs.size() == 4) {
            if (lastSplit == s.length()) {
                StringBuilder sb = new StringBuilder(subIPs.get(0));
                for (int i = 1; i < subIPs.size(); i++) {
                    sb.append(".").append(subIPs.get(i));
                }
                res.add(sb.toString());
                return;
            }
        }
        int subIPsNum = subIPs.size();

        for (int i = lastSplit + 1; i < Math.min(s.length() + 1, lastSplit + 4); i++) {
            if (i + (3 - subIPsNum) * 3 < s.length()) continue;
            String subIP = s.substring(lastSplit, i);
            if (hasLeadingZero(subIP) || !inRange(subIP)) {
                break;
            } else {
                subIPs.add(subIP);
                dfs(s, subIPs, i);
                subIPs.remove(subIPs.size() - 1);
            }
        }

    }

    private boolean hasLeadingZero(String s) {
        if (s.charAt(0) != '0' || s.length() == 1) {
            return false;
        } else {
            return true;
        }
    }

    private boolean inRange(String s) {
        int myInt = Integer.parseInt(s);
        return myInt >= 0 && myInt <= 255;
    }
}

