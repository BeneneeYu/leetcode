package dynamicProgramming.math.question96;

public class differentBinarySearchTree {
    public static int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int nums = 0;
        for (int i = 1; i <= n; i++) {
            nums += numTrees(i-1)*numTrees(n-i);
        }
        return nums;
    }

    public static void main(String[] args) {

        System.out.println(numTrees(4));
    }
}
