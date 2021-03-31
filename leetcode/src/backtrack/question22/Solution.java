package backtrack.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-03-31 21:21
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 不合法：右括号比左括号多
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result,"",n,0,0);
        return result;
    }
    //helper的基本条件：设置目标，尝试所有可能符合条件的尝试并消除影响
    public void helper(List<String> result,String tmpStr,int n,int left,int right){
        if (left == right && right == n){
            result.add(tmpStr);
            return;
        }
        //当左括号数没有超过对数，才有必要继续尝试放左的
        if(left < n){
            tmpStr = tmpStr + "(";
            helper(result,tmpStr,n,left+1,right);
            tmpStr = tmpStr.substring(0,tmpStr.length()-1);
        }
        //当右括号数没有超过左括号数，才有必要继续尝试放右的
        if(right < left){
            tmpStr = tmpStr + ")";
            helper(result,tmpStr,n,left,right+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(2));
    }
}
