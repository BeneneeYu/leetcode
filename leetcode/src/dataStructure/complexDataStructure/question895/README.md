# Problem

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the `FreqStack` class:

- `FreqStack()` constructs an empty frequency stack.
- `void push(int val)` pushes an integer `val` onto the top of the stack.
- `int pop()` removes and returns the most frequent element in the stack.
  - If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

**Constraints:**

- `0 <= val <= 109`
- At most `2 * 104` calls will be made to `push` and `pop`.
- It is guaranteed that there will be at least one element in the stack before calling `pop`.

# Ideas

Maintain a map to record the number of occurrences of `x`.

Maintain an integer to record the maximum frequency.

Among elements with the same (maximum) frequency, to pop the most recent element, we use a stack, let `group` be a map from frequency to a stack of elements with that frequency.

# Algorithm

## push

```java
        int freq = eleFreq.getOrDefault(val, 0) + 1;
        eleFreq.put(val, freq); // update element's frequency
        maxFreq = Math.max(freq, maxFreq); // update maximum frequency
        if (!group.containsKey(freq)) {
            group.put(freq, new Stack<>());
        }
        group.get(freq).push(val); // add the element to stack
```

## pop

```java
        int result = group.get(maxFreq).pop(); // maximum frequency and most recent
        eleFreq.put(result, maxFreq - 1); // update element's frequency
        if (group.get(maxFreq).empty()) {
            maxFreq -= 1;
        } // update maximum frequency
        return result;
```

