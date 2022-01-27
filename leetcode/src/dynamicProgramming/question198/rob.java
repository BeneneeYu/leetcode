package dynamicProgramming.question198;

public class rob {
    public static int rob(int[] nums,int start,int end) {
        int cur =0;
        int pre = 0;
        int tmp;
        for (int i = start; i < end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i],cur);
            pre = tmp;
        }
        return cur;
    }
    public static int rob2(int[] nums){
        if(nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,2};
        System.out.println(rob2(test));
    }
}
