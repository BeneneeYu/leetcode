package daily.question844;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-01 08:19
 **/
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getText(s).equals(getText(t));
    }
    private String getText(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#'){
                if (sb.length() >= 1){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
