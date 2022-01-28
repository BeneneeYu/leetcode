package array.question152;

public class maximumProductSequence {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp_max = new int[nums.length+1];
        int[] dp_min = new int[nums.length+1];
        dp_max[0] = 1;
        dp_min[0] = 1;
        int ma = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0){
                swap(dp_max,dp_min,i-1);
            }
            dp_max[i] = Math.max(dp_max[i-1]*nums[i],nums[i]);
            dp_min[i] = Math.min(dp_min[i-1]*nums[i],nums[i]);
            ma = Math.max(ma,dp_max[i]);
        }
        return ma;
    }
    private static void swap(int[] nums1,int[] nums2,int k){
        int  temp = nums1[k];
        nums1[k] = nums2[k];
        nums2[k] = temp;
    }
}
