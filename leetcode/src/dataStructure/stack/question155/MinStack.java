package dataStructure.stack.question155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 21:14
 **/
public class MinStack {
    Deque<Integer> elementStack;
    Deque<Integer> minStack;

    public MinStack() {
        elementStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        elementStack.push(val);
        minStack.push(val < minStack.peek() ? val : minStack.peek());
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */