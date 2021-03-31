package greedy.t455;

import java.util.Arrays;

public class distributeBiscuits {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int ga = 0;
        int sa = 0;
        int glength = g.length;
        int slength = s.length;
        while(ga < glength && sa<slength ){
            if (g[ga] <= s[sa]) {
                sum++;
                ga++;
                sa++;
            }
            else{
                sa++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        distributeBiscuits d = new distributeBiscuits();
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,1};

        System.out.println(d.findContentChildren(a,b));
    }
}
