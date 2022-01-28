package dynamicProgramming.greedy.question781;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 *


 * @author: Shen Zhengyu
 * @create: 2021-04-04 15:56
 **/
public class Solution {
    //同一个数字n，被声明的次数<=n+1次，可以信任，此色有n+1只.>n，只能代表不同的颜色
    //
    public int numRabbits1(int[] answers) {
        int minNum = 0;
        if (answers == null){
            return minNum;
        }
        HashMap<Integer,Integer> num = new HashMap<>();
        for (int answer : answers) {
            if (!num.containsKey(answer)){
                num.put(answer,1);
            }else{
                if (num.get(answer) <= answer){
                    num.put(answer,num.get(answer)+1);
                }else{
                    minNum += (answer+1);
                    num.remove(answer);
                    num.put(answer,1);
                }
            }
        }
        for (Integer integer : num.keySet()) {
            minNum = minNum + integer + 1;
        }
        return minNum;
    }
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            /*假设有13个回答5，为了最小化，则有3种颜色，其中2种12只都在其中，最少有18只
            x只回答y，至少有[x/(y+1)]={(x+y)/(y+1)}种颜色，每种y+1只（向上取整）
             */
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        System.out.println(s.numRabbits(new int[]{1, 1, 2}));
        System.out.println(s.numRabbits(new int[]{10, 10, 10}));
        System.out.println(s.numRabbits(new int[]{1,0,1,0,0}));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date.after(date));
        System.out.println(date2.after(date));
        System.out.println(date);
        System.out.println(date2);
    }
}
