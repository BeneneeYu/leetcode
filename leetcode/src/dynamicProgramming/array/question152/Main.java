package array.question152;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static String StringPeriods(String str) {
        int length = str.length();
        if(length <= 1){
            return "-1";
        }
        String result = "";
        int maxLength = 0;
        String[] strs = new String[length];
        for(int i = 0;i < length;i++){
            strs[i] = str.substring(i,length);
        }
        Arrays.sort(strs);
        for(int i = 0;i < length-1;i++){
            int max = longestSub(strs[i],strs[i+1]);
            if(max > maxLength){
                maxLength = max;
                result = strs[i].substring(0,maxLength);
            }
        }
        if(maxLength == 0){
            return "-1";
        }
        while(!StringPeriods(result).equals("-1")){
            result = StringPeriods(result);
        }
        maxLength = result.length();
        for(int i = 0;i < length / maxLength;i++){
            if(!str.substring(i*maxLength, Math.min((i+1)*maxLength,str.length())).equals(result)){
                return "-1";
            }
        }
        // code goes here
        return result;
    }
    private static int longestSub(String s1, String s2){
        if(s1.length() * s2.length() == 0){
            return 0;
        }
        int i = 0;
        while(i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)){
            i++;
        }
        return i;
    }
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringPeriods(s.nextLine()));
    }

}