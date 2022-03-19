# Question

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

# Thoughts

If `a` is pushed to the stack, before it is poped, elements that pushed before it are definitely in the stack.

So that we can push the min element to min_stack when we push element a.

# Solution

Design a data structure and make every element `a` correspond with min value `m`. Use a supplementary stack, push and pop the min value with every element in synchrony.

- When we push an element to stack, compare the peek element in min stack with it, push the smaller one to min stack.
- When we pop an element, pop the top element of min stack.
- At any time, the min value among elements in the stack is the peek of min stack.

