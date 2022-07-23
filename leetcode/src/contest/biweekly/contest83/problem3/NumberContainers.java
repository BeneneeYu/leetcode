package contest.biweekly.contest83.problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-07-23 22:42
 **/
public class NumberContainers {
    HashMap<Integer, ArrayList<Integer>> numberIndexesMap;
    HashMap<Integer, Integer> indexNumber;

    public NumberContainers() {
        numberIndexesMap = new HashMap<>();
        indexNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        int original;
        ArrayList<Integer> indexes;
        if (!indexNumber.containsKey(index)) {
            indexNumber.put(index, number);
            if (numberIndexesMap.containsKey(number)) {
                indexes = numberIndexesMap.get(number);
                int pos = findPosTo(indexes, index);
                indexes.add(pos, index);
            } else {
                indexes = new ArrayList<>();
                indexes.add(index);
            }
            numberIndexesMap.put(number, indexes);

        } else {
            original = indexNumber.get(index);
            indexNumber.put(index, number);
            indexes = numberIndexesMap.get(original);
            int pos = findPos(indexes, index);
            indexes.remove(pos);
        }
        if (numberIndexesMap.containsKey(number)) {
            indexes = numberIndexesMap.get(number);
            int pos = findPosTo(indexes, index);
            indexes.add(pos, index);
        } else {
            indexes = new ArrayList<>();
            indexes.add(index);
        }
        numberIndexesMap.put(number, indexes);
    }

    public int find(int number) {
        if (!numberIndexesMap.containsKey(number) || numberIndexesMap.get(number).size() == 0) {
            return -1;
        } else {
            return numberIndexesMap.get(number).get(0);
        }
    }

    private int findPosTo(ArrayList<Integer> list, int num) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int findPos(ArrayList<Integer> list, int num) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < num) {
                lo = mid + 1;
            } else if (list.get(mid) > num) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return lo;
    }
}


