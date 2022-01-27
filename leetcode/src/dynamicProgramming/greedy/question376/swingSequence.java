package dynamicProgramming.greedy.question376;

public class swingSequence {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) return length;
        int a = nums[0];
        int b = nums[1];
        int c = b - a;
        int sum = 1;
        for (int i = 1; i < length-1; i++) {
            a = b;
            b = nums[i+1];
            if (c * (b - a) <0){
                c = b - a;
                sum++;
            }
        }
        return sum+1;
    }

    public static void main(String[] args) {
        swingSequence sq = new swingSequence();
        int[] a = {3,3,3,2,5};
        System.out.println(sq.wiggleMaxLength(a));
    }
}
