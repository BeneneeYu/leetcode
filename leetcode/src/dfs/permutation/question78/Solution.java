package dfs.permutation.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-13 09:28
 **/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultLists = new ArrayList<>();
        for (int num : nums) {
            List<List<Integer>> additionList = new ArrayList<>();
            for (List<Integer> resultList : resultLists) {
                ArrayList<Integer> newList = new ArrayList<>(resultList);
                newList.add(num);
                additionList.add(newList);
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(num);
            resultLists.add(tmp);
            resultLists.addAll(additionList);
        }
        resultLists.add(new ArrayList<>());
        return resultLists;
    }
}
