package dataStructure.complexDataStructure.question895;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-03-19 11:10
 **/
public class FreqStack {
    HashMap<Integer, Integer> eleFreq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> group = new HashMap<>();
    int maxFreq = 0;

    public void push(int val) {
        int freq = eleFreq.getOrDefault(val, 0) + 1;
        eleFreq.put(val, freq);
        maxFreq = Math.max(freq, maxFreq);
        if (!group.containsKey(freq)) {
            group.put(freq, new Stack<>());
        }
        group.get(freq).push(val);
    }

    public int pop() {
        int result = group.get(maxFreq).pop();
        eleFreq.put(result, maxFreq - 1);
        if (group.get(maxFreq).empty()) {
            maxFreq -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
