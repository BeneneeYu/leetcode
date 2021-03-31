package sorting.t179;

import java.util.Arrays;
import java.util.Comparator;

public class maxNumber {
    private class LargeNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);

        }
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,new LargeNumberComparator());
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
        }

}
