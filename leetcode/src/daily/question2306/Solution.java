package daily.question2306;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public long distinctNames(String[] ideas) {
        long res = 0;
        // cnt[m][n]: the number of words whose first letter is originally m + 'a'
        // and are not in ideaSet when its first letter is changed to n + 'a'
        int[][] cnt = new int[26][26];
        HashMap<String, Integer> tailHeadMap = new HashMap<>();
        for (String idea : ideas) {
            String tail = idea.substring(1);
            // set the digit to 1
            tailHeadMap.put(tail, tailHeadMap.getOrDefault(tail, 0) | (1 << (idea.charAt(0) - 'a')));
        }

        for (String idea : ideas) {
            char head = idea.charAt(0);
            String tail = idea.substring(1);
            int num = tailHeadMap.get(tail);
            for (int i = 0; i < 26; i++) {
                if ((num & (1 << i)) == 0){
                    cnt[head - 'a'][i] += 1;
                }
            }
        }

        for (String idea : ideas) {
            char head = idea.charAt(0);
            String tail = idea.substring(1);
            int num = tailHeadMap.get(tail);
            for (int i = 0; i < 26; i++) {
                if ((num & (1 << i)) == 0){
                    res += cnt[i][head - 'a'];
                }
            }
        }
        return res;
    }

    public long distinctNamesPassed1(String[] ideas) {
        long res = 0;
        HashSet<String> ideaSet = new HashSet<>(List.of(ideas));
        // cnt[m][n]: the number of words whose first letter is originally m + 'a'
        // and are not in ideaSet when its first letter is changed to n + 'a'
        int[][] cnt = new int[26][26];

        for (String idea : ideas) {
            char head = idea.charAt(0);
            String tail = idea.substring(1);
            for (int i = 0; i < 26; i++) {
                char newHead = (char)(i+'a');
                if (head == newHead) continue;
                if (!ideaSet.contains(newHead + tail)){
                    cnt[head - 'a'][i] += 1;
                }
            }
        }

        for (String idea : ideas) {
            char head = idea.charAt(0);
            String tail = idea.substring(1);
            for (int i = 0; i < 26; i++) {
                char newHead = (char)(i+'a');
                if (head == newHead) continue;
                if (!ideaSet.contains(newHead + tail)){
                    res += cnt[i][head - 'a'];
                }
            }
        }
        return res;
    }

    public long distinctNamesNotPassed(String[] ideas) {
        HashMap<String, boolean[]> tailHeadMap = new HashMap<>();
        for (String idea : ideas) {
            String tail = idea.substring(1);
            boolean[] occur = tailHeadMap.getOrDefault(tail, new boolean[26]);
            occur[idea.charAt(0) - 'a'] = true;
            tailHeadMap.put(tail, occur);
        }
        long res = 0;
        int n = ideas.length;
        for (int i = 0; i < n; i++) {
            char head1 = ideas[i].charAt(0);
            String tail1 = ideas[i].substring(1);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                char head2 = ideas[j].charAt(0);
                String tail2 = ideas[j].substring(1);
                // If both of the new names are not found in the original ideas
                // head1 + tail2, head2 + tail1
                if (tailHeadMap.get(tail1)[head2 - 'a'] || tailHeadMap.get(tail2)[head1 - 'a']) continue;
                res += 1L;
                System.out.println(head2 + tail1 + " " + head1 + tail2 + " valid");
            }
        }
        return res;
    }
}
