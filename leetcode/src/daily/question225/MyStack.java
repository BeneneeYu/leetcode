package daily.question225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-05 09:48
 **/
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    public MyStack() {
        queue1  = new LinkedList<>();
        queue2  = new LinkedList<>();

    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        while (queue1.size() > 1){
            top = queue1.remove();
            queue2.add(top);
        }
        int res = queue1.remove();
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
