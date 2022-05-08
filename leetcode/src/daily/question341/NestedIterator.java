package daily.question341;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-08 14:14
 **/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation

 */

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> valueList;
    private Iterator<Integer> cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        valueList = new ArrayList<>();
        dfs(nestedList);
        cur = valueList.iterator();
    }

    // every integer element is a leaf node
    // every list is a non-leaf node
    // the traversal order of depth first search is the sequence of iterator
    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()){
                valueList.add(nestedInteger.getInteger());
            }else{
                dfs(nestedInteger.getList());
            }
        }
    }
    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */