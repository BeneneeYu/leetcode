# Question

Given a collection of numbers, `nums`, that might contain duplicates, return *all possible unique permutations **in any order**.*

# Solution

Backtracking algorithm with no duplicates in enumerated solutions.

Backtracking is a general algorithm for finding all (or some) solutions to some problems with constraints. It incrementally builds candidates to the solutions, and abandons a candidate as soon as it determines that the candidate cannot possibly lead to a solution.

Stage: Pick one number into the permutation out of available numbers, try out all choices and revert each choice with another alternative until there is no more choice.

The key to avoid duplicates is to consider each unique number as the true candidate.

# Algorithm

To find all unique numbers at every stage, we use a map to record every number and its appearing times.

