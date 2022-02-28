package multiplePointer.array.question228;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-28 09:31
 **/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (null == nums) {
            return result;
        }
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int low = i;
            i++;
            while (i < len && nums[i - 1] + 1 == nums[i]) {
                i++;
            }
            int high = i - 1;
            StringBuilder sb = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(Integer.toString(nums[high]));
            }
            result.add(sb.toString());
        }
        return result;
    }
}
