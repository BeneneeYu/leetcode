# Depth First Search

**Depth-first search** (**DFS**) is an [algorithm](https://en.wikipedia.org/wiki/Algorithm) for traversing or searching [tree](https://en.wikipedia.org/wiki/Tree_data_structure) or [graph](https://en.wikipedia.org/wiki/Graph_(data_structure)) data structures. The algorithm starts at the [root node](https://en.wikipedia.org/wiki/Tree_(data_structure)#Terminology) (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.

# Case

- Find all satisfied solutions
- Problems on binary tree
- Problems on combination
- Problems on permutation

**Do not use DFS but BFS:**

- Problems on connected block
- Problems on topological sort
- All the problems that can be solved by BFS

# Topics

1. The essential factors of recursion in DFS.
2. The selection of termination conditions; backtrack; prune.
3. When to sort?
4. How to remove duplicate elements?
5. The cases when an element can be used for several times?
6. How to avoid get to a duplicate node in traversal when performing DFS on a graph.
7. Recognize an implicit graph and perform DFS on it.
8. Use memorized search and optimize.

# Complexity

Number of solutions * time to figure out a solution

Traversal on tree: $O(n)$

permutation: $O(n!*n)$

combination: $O(2^n*n)$

# Template

```Java
public ReturnType dfs(argumentList){
	if(exit of recursion){
		storeAnswer();
		return;
	}
    for(All disassembly possibilities){
        modifyArguments();
        dfs(argumentList);
        // if necessary
        return something;
        restoreModifiedArguments();
    }
    // if necessary
    return something;
}
```

# Backtrack

During the process, if it finds that the path it tries out will not be a solution, it returns and restore the global variable, while DFS traverse the entire search space.

## Subsets

https://leetcode.com/problems/subsets/

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

// pass start to avoid duplications
private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1); // choosing nums[i]
        tempList.remove(tempList.size() - 1); // not choosing nums[i]
    }
}
```

## Subsets II

contains duplicates

https://leetcode.com/problems/subsets-ii/

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates, e.g. [1,2,2], or else there will be two [1,2]
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1); // select this element, construct the rest part
        tempList.remove(tempList.size() - 1); // traverse into next round, not selecting this element
    }
} 
```

## Combinations

https://leetcode.com/problems/combinations/

```java
public class Solution {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }

    private void dfs(int start, int n, int k) {
        if (path.size() + n - start + 1 < k) return;
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        dfs(start + 1, n, k);
        path.remove(path.size() - 1);
        dfs(start + 1, n, k);
    }
}
```

## Permutations

https://leetcode.com/problems/permutations/

```java
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 
```

## Permutations II 

contains duplicates

https://leetcode.com/problems/permutations-ii/

```java
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

use `!use[i - 1]` for efficiency.

`if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue;` means, in other words, `if previous identical number is used, then use the current number`.

because if you use the opposite way, `if (i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;` which means `if previous identical number is NOT used, use this number`, you are going to have to keep running the program until the next identical number first populates the `temp/list` array before the previous identical number, and then you backtrack into the first identical number which then populates the `temp/list` array.
That one is using `if (i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;`. You will see that the `result` array really starts to populate near the end of `for` loop when `i = 2`.
In contrast, the first picture using `if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue;` shows that the `result` array starts populating in the beginning.

## Combination Sum

https://leetcode.com/problems/combination-sum/

```java
public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## Combination Sum II

can't reuse same element

https://leetcode.com/problems/combination-sum-ii/

```java
public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 
```

## Palindrome Partitioning

https://leetcode.com/problems/palindrome-partitioning/

```java
public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(tempList)); // pointer reaches, valid split
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1); // split here
            tempList.remove(tempList.size() - 1); // not split here
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 
```
