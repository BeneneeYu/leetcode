# Question

Given a balanced parentheses string `s`, return *the **score** of the string*.

The **score** of a balanced parentheses string is based on the following rule:

- `"()"` has score `1`.
- `AB` has score `A + B`, where `A` and `B` are balanced parentheses strings.
- `(A)` has score `2 * A`, where `A` is a balanced parentheses string.

# Idea

Every position in the string has a *depth* - some number of matching parentheses surrounding it. For example, the dot in `(()(.()))` has depth 2, because of these parentheses: `(__(.__))`

Our goal is to maintain the score at the current depth we are on. When we see an opening bracket, we increase our depth, and our score at the new depth is 0. When we see a closing bracket, we add twice the score of the previous deeper part - except when counting `()`, which has a score of 1.

```java
                int tmpScore = stack.pop();
                int overallScore = stack.pop();
                if (tmpScore == 0) {
                    tmpScore = 1; // case of '()'
                } else {
                    tmpScore *= 2; // double the inner score
                }
                stack.push(overallScore + tmpScore);
```

