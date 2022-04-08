package dataStructure.string.question68;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-07 14:55
 **/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    // find the right border of words range of this line
    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right].length();
        right += 1;
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += (1 + words[right].length());
            right += 1;
        }
        return right - 1;
    }

    // find an appropriate range and generate a well-formed line
    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right == left) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = (right == words.length - 1);
        int wordCount = right - left;
        // total num of spaces we should insert into a line
        int totalSpaceCount = maxWidth - wordsLength(left, right, words);
        // appropriate num of blank space between every character
        String spaceString = isLastLine ? " " : blank(totalSpaceCount / wordCount);
        // remainder space to insert
        int remainder = isLastLine ? 0 : totalSpaceCount % wordCount;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(spaceString) // the fixed space
                    .append(remainder-- > 0 ? " " : ""); // append one space if not zero

        return padResult(result.toString().trim(), maxWidth);
    }

    // count the total num of characters
    private int wordsLength(int left, int right, String[] words) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += words[i].length();
        }
        return res;
    }

    // append a blank string to a well-formed content line
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    // generate a blank string with length n
    private String blank(int n) {
        return new String(new char[n]).replace('\0', ' ');
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.blank(3));
        System.out.println(s.padResult("I am I", 15));
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(s.fullJustify(words, 16));
    }
}
