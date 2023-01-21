package dfs.backtrack.question93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<String> result;
    int len;

    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        result = new ArrayList<>();
        if (len < 4 || len > 12){
            return result;
        }
        helper(new ArrayList<>(), s, 0);
        return result;
    }

    private void helper(List<String> subIPs, String s, int lastSplit) {
        if (subIPs.size() == 4) {
            if (lastSplit == len) {
                result.add(String.join(".", subIPs.stream().toList()));
            }
        }
        int subIPsNum = subIPs.size();
        // !important: len + 1 but not len
        for(int i = lastSplit + 1; i < Math.min(len + 1, lastSplit + 4); i++){
            if (i + (3 - subIPsNum) * 3 < s.length()) continue;
            String subIP = s.substring(lastSplit, i);
            if (hasLeadingZero(subIP) || !inRange(subIP)){
                break;
            }else {
                subIPs.add(subIP);
                helper(subIPs, s, i);
                subIPs.remove(subIPs.size() - 1);
            }
        }
    }

    private boolean hasLeadingZero(String num) {
        return num.length() != 1 && num.charAt(0) == '0';
    }

    private boolean inRange(String num) {
        return Integer.parseInt(num) >= 0 && Integer.parseInt(num) <= 255;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.restoreIpAddresses("25525511135").toArray()));
    }
}