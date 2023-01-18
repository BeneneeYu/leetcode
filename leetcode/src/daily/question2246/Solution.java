package daily.question2246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer>[] g;
    String s;
    int ans;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        var n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var i = 1; i < n; i++) g[parent[i]].add(i);

        dfs(0);
        return ans + 1;
    }

    int dfs(int x) {
        var maxLen = 0;
        for (var y : g[x]) {
            var len = dfs(y) + 1;
            if (s.charAt(y) != s.charAt(x)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
