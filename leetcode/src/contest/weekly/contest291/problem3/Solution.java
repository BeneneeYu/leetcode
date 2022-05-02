package contest.weekly.contest291.problem3;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-01 10:18
 **/
public class Solution {
    // num % p == 0
    int res = 0;
    public int countDistinct(int[] nums, int k, int p) {
        HashMap<Integer, Integer> exactDivision = new HashMap<>();
        HashMap<Integer, Integer> notExactDivision = new HashMap<>();

        for (int num : nums) {
            if (num % p == 0){
                exactDivision.put(num, exactDivision.getOrDefault(num, 0) + 1);
            }else{
                notExactDivision.put(num, notExactDivision.getOrDefault(num, 0) + 1);
            }
        }
//        for (Integer integer : exactDivision.keySet()) {
//            System.out.println(integer + ": " + exactDivision.get(integer));
//        }
//        for (Integer integer : notExactDivision.keySet()) {
//            System.out.println(integer + ": " + notExactDivision.get(integer));
//        }
        dfs(exactDivision, notExactDivision, 0, k, new ArrayList<>());
        return  res - 1;
    }
    private void dfs(HashMap<Integer, Integer> exactDivision, HashMap<Integer, Integer> notExactDivision, int kNum, int k, ArrayList<Integer> list){
        if (kNum > k){
            return;
        }else{
            res += 1;
        }
        // nums that can be used
        Set<Integer> mySet = new HashSet<>();
        Set<Integer> exactSet = exactDivision.keySet();
        Set<Integer> notExactSet = notExactDivision.keySet();
        if (kNum < k){
            mySet.addAll(exactSet);
        }
        mySet.addAll(notExactSet);
//        System.out.println("-----");
//        for (Integer integer : mySet) {
//            System.out.println(integer);
//        }
//        System.out.println("-----");
//        System.out.println("Myset" + Arrays.toString(mySet.toArray()));
        for (Integer integer : mySet) {
            // can not divide
            if (notExactSet.contains(integer)){
//                System.out.println("not exact");
                HashMap<Integer, Integer> tmp1 = new HashMap<>(notExactDivision);
                HashMap<Integer, Integer> tmp2 = new HashMap<>(exactDivision);

                if (tmp1.get(integer) == 1){
                    tmp1.remove(integer);
                }else{
                    tmp1.put(integer, tmp1.get(integer) - 1);
                }
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(integer);
                System.out.println(Arrays.toString(tmp.toArray()));
                dfs(tmp2, tmp1, kNum, k, tmp);
            }else{
                HashMap<Integer, Integer> tmp1 = new HashMap<>(exactDivision);
                HashMap<Integer, Integer> tmp2 = new HashMap<>(notExactDivision);

                if (tmp1.get(integer) == 1){
                    tmp1.remove(integer);
                }else{
                    tmp1.put(integer, tmp1.get(integer) - 1);
                }
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(integer);
                System.out.println(Arrays.toString(tmp.toArray()));
                dfs(tmp1, tmp2, kNum + 1, k,tmp);
            }
        }
    }
}
