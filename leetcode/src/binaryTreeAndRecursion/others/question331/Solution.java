package binaryTreeAndRecursion.others.question331;

import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-16 15:59
 **/
public class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : preorder.split(",")) {
            stack.push(s);
            while (stack.size() >= 3
                    && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
    public boolean isValidSerialization2(String preorder) {
        int diff = 1;
        for(String s : preorder.split(",")){
            diff--;
            if (diff < 0){
                return false;
            }
            if(!s.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}
