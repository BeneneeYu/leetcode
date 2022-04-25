package daily.question284;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-25 17:23
 **/
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    // the result of next()
    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer ret = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));
        Iterator iterator = list.iterator();


        PeekingIterator peekingIterator = new PeekingIterator(iterator); // [1,2,3]
        System.out.println(peekingIterator.peek()); // 1
        System.out.println(peekingIterator.next()); // 1
        System.out.println(peekingIterator.peek()); // 2
        System.out.println(peekingIterator.next()); // 2
        System.out.println(peekingIterator.next()); // 3
        System.out.println(peekingIterator.hasNext()); // false


    }
}
