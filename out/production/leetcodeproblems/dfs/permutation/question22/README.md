# Question

Given `n` pairs of parentheses, write a function to *generate all combinations of well-formed parentheses*.

**Example 1:**

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

# Solution

The brute force is to generate all the sequences by add `(`and `)` and check if each one is valid(the net number of opening brackets minus closing brackets. If it falls below zero at any time, or doesn't end in zero, the sequence is invalid - otherwise it is valid).

## Backtracking

By keeping track of the number of opening and closing brackets we have placed so far, we can add brackets only when we know it will remain a valid sequence.

We can start an opening bracket(`(`)  if we still have one (of `n`) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.

According to the template,

```java
public void dfs(argumentList){
	if(not a valid brackets permutation){
		return;
	}
	if(a valid, closed permutation){
	    storeResult();
		return;
	}
    for(All disassembly possibilities){
        modifyArguments();
        dfs(argumentList);
        // if necessary
        return something;
        restoreModifiedArguments(); // delete the appended bracket
    }
    // if necessary
    return something;
}
```

## Dynamic Programming

Consider the leftmost bracket, it must be an open bracket `(`, and its corresponding closed bracket `)`, we think that this group is an added parenthesis, and it's the `nth`. The rest `n-1` pair of brackets can be `p` pairs on the left side of `)`, and `q` pairs on the right side.

`p + q == n - 1, p < n - 1, q < n -1` so that we can use data structure to store the intermediate result of every argument from 0 to `n` to support the state transition.

