# DFS

- 状态: 每个结点表示了求解问题的不同阶段
- 回到上一层结点时需**状态重置**
- 通常可以使用以下的**状态变量：**
- 递归到第几层 `depth` 递归路径 `path` 布尔数组 `used`

```java
	   public List<List<Integer>> levelOrder(TreeNode root) {
           List<List<Integer>> allResults = new ArrayList<>();
           if(root==null){
               return allResults;
           }
           travel(root,0,allResults);
           return allResults;
       }

       private void travel(TreeNode root,int level,List<List<Integer>> results){
           if(results.size()==level){
               results.add(new ArrayList<>());
           }
           results.get(level).add(root.val);
           if(root.left!=null){
               travel(root.left,level+1,results);
           }
           if(root.right!=null){
               travel(root.right,level+1,results);
           }
       }
```

```python
DFS模板
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```





```java
//求子集
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        //1.定义走过的路径track
        ArrayList<Integer> track = new ArrayList<>();
        //2.开启backtrace
        backtrack(nums, 0, track);
        
        return res;
    }
    
    public void backtrack(int[] nums, int start, ArrayList<Integer> track){
        //1.将已走过(遍历)的路径track加入res
        //如果没有new,虽然每次res中子数组的数量一次增加，但track的值都是一样的。
        //因为add一直是同一个track地址。到后面删除track中的元素时，因为之前添加的地址都一样，所以后面删除元素，之前的也会删除。
        res.add(new ArrayList<>(track));
        //2.在列表中做选择
        for(int i = start; i < nums.length; i++){
            //2.1 将当前值加入track
            track.add(nums[i]);
            //2.2 回溯，加入下一个数字。进入下一层
            backtrack(nums, i + 1, track);
            //2.3 撤销操作
            track.remove(track.size() - 1);
        }
    }
    
}
```



# BFS

```java
public class BFSTemplate {
    // 计算从起点 start 到终点 target 的最近距离
    public int BFS(Node start, Node target) {
        Queue<Node> q = new LinkedList<>(); // 核心数据结构
        Set<Node> visited = new HashSet<>(); // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.neighbors)
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }

    /*
     * BFS模板：
     * 条件判断（边界判断，其他要求的判断）
     *
     * 创建队列
     *
     * 在队列中加入第一个满足条件的元素
     *
     * while(队列不为空) {
     *     取出队列头部元素
     *     操作
     *     根据头部元素，往队列中再次加入满足条件的元素
     * }
     */

    /*
     * DFS模板：
     * dfs出口，不满足条件就退出
     *
     * 操作
     *
     * 递归，接着进一步DFS
     */
}
```

# Backtracking

## 背景

回溯法（backtrack）常用于遍历列表所有子集，是 DFS 深度搜索一种，一般用于全排列，穷尽所有可能，遍历的过程实际上是一个决策树的遍历过程。时间复杂度一般 O(N!)，它不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。

## 模板

```go
result = []
func backtrack(选择列表,路径):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(选择列表,路径)
        撤销选择
```

核心就是从选择列表里做一个选择，然后一直递归往下搜索答案，如果遇到路径不通，就返回来撤销这次选择。

## 常见例题

### 集合类

#### 子集

> [78. 子集](https://leetcode-cn.com/problems/subsets/)
>
> 给你一个整数数组 `nums` ，数组中的元素 **互不相同** 。返回该数组所有可能的子集（幂集）。

```java
public List<List<Integer>> subsets(int[] nums) {
	// 保存中间结果
    List<Integer> subSet = new ArrayList<>();
    // 保存最终结果
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, subSet, result);
    return result;
}

// nums 给定的集合
// pos 下次添加到集合中的元素位置索引
// subSet 临时结果集合(每次需要复制保存)
// result 最终结果
private void backtrack(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result) {
    // 把临时结果复制出来保存到最终结果
    result.add(new ArrayList<>(subSet));
    for (int i = pos; i < nums.length; i++) {
        // 选择、处理结果、再撤销选择
        subSet.add(nums[i]);
        backtrack(nums, i+1, subSet, result);
        subSet.remove(subSet.size() - 1);
    }
}
```

#### 子集 II

>  [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)
>
>  给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。

```java
public List<List<Integer>> subsets(int[] nums) {
	// 保存中间结果
    List<Integer> subSet = new ArrayList<>();
    // 保存最终结果
    List<List<Integer>> result = new ArrayList<>();
	// 先排序
    Arrays.sort(nums);
    backtrack(nums, 0, subSet, result);
    return result;
}

// nums 给定的集合
// pos 下次添加到集合中的元素位置索引
// subSet 临时结果集合(每次需要复制保存)
// result 最终结果
private void backtrack(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result) {
    // 把临时结果复制出来保存到最终结果
    result.add(new ArrayList<>(subSet));
    for (int i = pos; i < nums.length; i++) {
        // 排序之后，如果再遇到重复元素，则不选择此元素
        if (i != pos && nums[i] == nums[i-1]) {
            continue;
        }
        // 选择、处理结果、再撤销选择
        subSet.add(nums[i]);
        backtrack(nums, i+1, subSet, result);
        subSet.remove(subSet.size() - 1);
    }
}
```

### 排列类

#### 全排列

> [46. 全排列](https://leetcode-cn.com/problems/permutations/)
>
> 给定一个 **没有重复** 数字的序列，返回其所有可能的全排列。

思路：需要记录已经选择过的元素，满足条件的结果才进行返回。这里要注意在做选择时记录，回溯时撤销。

```java
public List<List<Integer>> permute(int[] nums) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    // 标记这个元素是否已经添加到结果集
    boolean[] visited = new boolean[nums.length];
    backtrack(nums, visited, list, result);
    return result;
}

// nums 输入集合
// visited 当前递归标记过的元素
// list 临时结果集(路径)
// result 最终结果
private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == nums.length) {
        result.add(new ArrayList<>(list));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
         // 已经添加过的元素，直接跳过
        if (visited[i]) {
            continue;
        }
        // 添加元素
        list.add(nums[i]);
        visited[i] = true;
        backtrack(nums, visited, list, result);
        // 移除元素
        list.remove(list.size() - 1);
        visited[i] = false;
    }
}
```

#### 全排列 II

> [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
>
> 给定一个可包含重复数字的序列，返回所有不重复的全排列。

```java
public List<List<Integer>> permuteUnique(int[] nums) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
	// 标记这个元素是否已经添加到结果集
    boolean[] visited = new boolean[nums.length];
    // 先排序
    Arrays.sort(nums);
    backtrack(nums, visited, list, result);
    return result;
}

// nums 输入集合
// visited 当前递归标记过的元素
// list 临时结果集
// result 最终结果
private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == nums.length) {
        result.add(new ArrayList<>(list));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
		// 已经添加过的元素，直接跳过
        if (visited[i]) {
            continue;
        }
        // 上一个元素和当前相同，并且没有访问过就跳过
        if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) {
            continue;
        }
        list.add(nums[i]);
        visited[i] = true;
        backtrack(nums, visited, list, result);
        list.remove(list.size() - 1);
        visited[i] = false;
    }
}

```

### 组合类

#### 组合总和

> [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)
>
> 给定一个**无重复元素**的数组 `candidates` 和一个目标数 `target` ，找出 `candidates` 中所有可以使数字和为 `target` 的组合。
>
> `candidates` 中的数字可以无限制重复被选取。
>
> **说明：**
>
> - 所有数字（包括 `target`）都是正整数。
> - 解集不能包含重复的组合。 

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> answer = new ArrayList();
    List<List<Integer>> result = new ArrayList();
    // 先排序
    Arrays.sort(candidates);
    backtrack(candidates, 0, target, answer, result);
    return result;
}

// candidates 输入集合
// pos 当前标记位置，标记前的元素不再考虑
// target 求和目标
// answer 临时解法
// result 最终结果
private void backtrack(int[] candidates, int pos, int target, List<Integer> answer, List<List<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<>(answer));
    }
    for (int i = pos; i < candidates.length; i++) {
        // 剪枝：后续元素都比目标大，直接break（比continue要快）
        if (candidates[i] > target) {
            break;
        }
        // 添加元素
        answer.add(candidates[i]);
        // 元素可以重复取，所以从当前位置继续
        backtrack(candidates, i, target - candidates[i], answer, result);
        // 移除元素
        answer.remove(answer.size() - 1);
    }
}
```

#### 电话号码的字母组合

> [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
>
> 给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。答案可以按 **任意顺序** 返回。
>
> 数字到字母的映射与电话按键相同

```java
// 记录数字到字母的映射
private final static Map<Character, String> map = new HashMap<>();

static {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
}

public List<String> letterCombinations(String digits) {
    StringBuilder builder = new StringBuilder();
    List<String> result = new ArrayList<>();
    backtrack(digits, 0, builder, result);
    return result;
}

private void backtrack(String digits, int pos, StringBuilder builder, List<String> result) {
    // 结束条件：到达末尾
    if (pos == digits.length()) {
        // 如果原字符串为空则没有对应的字母组合
        if (pos != 0) {
            result.add(builder.toString());
        }
        return;
    }
    for (char c : map.get(digits.charAt(pos)).toCharArray()) {
        builder.append(c);
        backtrack(digits, pos + 1, builder, result);
        builder.deleteCharAt(builder.length() - 1);
    }
}
```

# Sort

## 常考排序

### 快速排序

```java
public void quickSort(int[] nums) {
    // 思路：把一个数组分为左右两段，左段小于右段
    quickSort(nums, 0, nums.length - 1);
}

// 原地交换，所以传入交换索引
private void quickSort(int[] nums, int start, int end) {
    if (start < end) {
        // 分治法：divide
        int pivot = partition(nums, start, end);
        quickSort(nums, 0, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
}

// 分区
private int partition(int[] nums, int start, int end) {
    // 选取最后一个元素作为基准pivot
    int p = nums[end];
    int i = start;
    // 最后一个值就是基准所以不用比较
    for (int j = start; j < end; j++) {
        if (nums[j] < p) {
            swap(nums, i, j);
            i++;
        }
    }
    // 把基准值换到中间
    swap(nums, i, end);
    return i;
}

// 交换两个元素
private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

### 归并排序

```java
public void mergeSort(int[] nums) {
    mergeSort(nums, 0, nums.length);
}

private void mergeSort(int[] nums, int start, int end) {
    if (end - start <= 1) {
        return;
    }
    // 分治法：divide 分为两段
    int mid = start + (end - start) / 2;
    mergeSort(nums, start, mid);
    mergeSort(nums, mid, end);
    // 合并两段数据
    merge(nums, start, mid, end);
}

private void merge(int[] nums, int start, int mid, int end) {
    int[] temp = new int[end - start];
    // 两边数组合并游标
    int l = start;
    int r = mid;
    int k = 0;
    // 注意不能越界
    while (l < mid && r < end) {
        // 谁小合并谁
        if (nums[l] < nums[r]) {
            temp[k++] = nums[l++];
        } else {
            temp[k++] = nums[r++];
        }
    }
    // 剩余部分合并
    while (l < mid) {
        temp[k++] = nums[l++];
    }
    while (r < end) {
        temp[k++] = nums[r++];
    }
    // 复制到原数组
    for (int i = 0; i < temp.length; i++) {
        nums[i + start] = temp[i];
    }
}
```

### 堆排序

用数组表示的完全二叉树 complete binary tree

> 完全二叉树 VS 其他二叉树

![image.png](https://img.fuiboom.com/img/tree_type.png)

[动画展示](https://www.bilibili.com/video/av18980178/)

![image.png](https://img.fuiboom.com/img/heap.png)

核心代码

```java
public void heapSort(int[] nums) {
    // 1、无序数组nums
	// 2、将无序数组nums构建为一个大根堆
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
        sink(nums, i, nums.length);
    }
    // 3、交换nums[0]和nums[len(a)-1]
	// 4、然后把前面这段数组继续下沉保持堆结构，如此循环即可
    for (int i = nums.length - 1; i >= 0; i--) {
        // 从后往前填充值
        swap(nums, 0, i);
        // 前面的长度也减一
        sink(nums, 0, i);
    }
}

private void sink(int[] nums, int i, int length) {
    while (true) {
        // 左节点索引(从0开始，所以左节点为i*2+1)
        int l = i * 2 + 1;
        // 右节点索引
        int r = i * 2 + 2;
        // 保存根、左、右三者之间较大值的索引
        int index = i;
        // 存在左节点，左节点值较大，则取左节点
        if (l < length && nums[l] > nums[index]) {
            index = l;
        }
        // 存在右节点，且值较大，取右节点
        if (r < length && nums[r] > nums[index]) {
            index = r;
        }
        // 如果根节点较大，则不用下沉
        if (index == i) {
            break;
        }
        // 如果根节点较小，则交换值，并继续下沉
        swap(nums, i, index);
        i = index;
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

## 参考

[十大经典排序](https://www.cnblogs.com/onepixel/p/7674659.html)

[二叉堆](https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-dui-xiang-jie-shi-xian-you-xian-ji-dui-lie)

# SlidingWindow

## 模板

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

需要变化的地方

- 1、右指针右移之后窗口数据更新
- 2、判断窗口是否要收缩
- 3、左指针右移之后窗口数据更新
- 4、根据题意计算结果

## 示例

### 最小覆盖子串

> [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)
>
> 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串

```java
public String minWindow(String s, String t) {
    // 技巧：用数组代替Map
    // 保存滑动窗口字符集
    int[] winMap = new int[256];
    // 保存需要出现的字符集
    int[] tMap = new int[256];
    for (char c : t.toCharArray()) {
        tMap[c]++;
    }
    // 计算共出现了多少不同的字符
    int charNum = 0;
    for (int n : tMap) {
        if (n > 0) {
            charNum++;
        }
    }
    // 滑动窗口左右边界
    int left = 0;
    int right = 0;
    // 匹配数
    int match = 0;
    // 窗口调整前暂存原窗口边界
    int start = 0;
    int end = 0;
    // 窗口长度的最小值
    int minValue = Integer.MAX_VALUE;
    while (right < s.length()) {
        char c = s.charAt(right);
        // 在需要的字符集里面，添加到窗口字符集里面
        if (tMap[c] != 0) {
            winMap[c]++;
            // 如果当前字符的数量匹配需要的字符的数量，则match值+1
            if (tMap[c] == winMap[c]) {
                match++;
            }
        }
        right++;
        // 当所有字符数量都匹配之后，开始缩紧窗口
        while (match == charNum) {
            // 获取结果
            if (right - left < minValue) {
                minValue = right - left;
                start = left;
                end = right;
            }
            char leftChar = s.charAt(left);
            // 左指针指向不在需要字符集则直接跳过
            if (tMap[leftChar] != 0) {
                // 左指针指向字符数量和需要的字符相等时，右移之后match值就不匹配则减一
                if (winMap[leftChar] == tMap[leftChar]) {
                    match--;
                }
                winMap[leftChar]--;
            }
            left++;
        }
    }
    if (minValue == Integer.MAX_VALUE) {
        return "";
    }
    return s.substring(start, end);
}
```

### 字符串的排列

> [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)
>
> 给定两个字符串  **s1**  和  **s2**，写一个函数来判断  **s2**  是否包含  **s1 **的排列。

```java
public boolean checkInclusion(String s1, String s2) {
    // 保存滑动窗口字符集
    int[] winMap = new int[256];
    // 保存需要出现的字符集
    int[] tMap = new int[256];
    for (char c : s1.toCharArray()) {
        tMap[c]++;
    }
    // 计算共出现了多少不同的字符
    int charNum = 0;
    for (int n : tMap) {
        if (n > 0) {
            charNum++;
        }
    }
    // 左右边界
    int left = 0;
    int right = 0;
    // 已经匹配的字母数
    int match = 0;

    while (right < s2.length()) {
        char c = s2.charAt(right);
        right++;
        if (tMap[c] != 0) {
            winMap[c]++;
            if (winMap[c] == tMap[c]) {
                match++;
            }
        }
        // 窗口收缩
        while (match == charNum) {
            c = s2.charAt(left);
            if (tMap[c] != 0) {
                if (winMap[c] == tMap[c]) {
                    match--;
                }
                winMap[c]--;
            }
            left++;
            // 子串是一个排列，即子串长度等于s1
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
    }
    return false;
}
```

### 找到字符串中所有字母异位词

> [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
>
> 给定一个字符串  **s **和一个非空字符串  **p**，找到  **s **中所有是  **p **的字母异位词的子串，返回这些子串的起始索引。

```java
public List<Integer> findAnagrams(String s, String p) {
    int[] pMap = new int[256];
    int[] winMap = new int[256];
    int charNum = 0;
    for (char c : p.toCharArray()) {
        if (pMap[c] == 0) charNum++;
        pMap[c]++;
    }
    int left = 0;
    int right = 0;
    int match = 0;
    List<Integer> result = new ArrayList<>();
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        if (pMap[c] != 0) {
            winMap[c]++;
            if (pMap[c] == winMap[c]) {
                match++;
            }
        }
        // 缩紧窗口
        while (match == charNum) {
            c = s.charAt(left);
            if (pMap[c] != 0) {
                if (pMap[c] == winMap[c]) {
                    match--;
                }
                winMap[c]--;
            }
            // 当窗口长度和字符串长度匹配时，满足条件
            if (right - left == p.length()) {
                result.add(left);
            }
            left++;
        }
    }
    return result;
}
```

### 无重复字符的最长子串

> [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
>
> 给定一个字符串，请你找出其中不含有重复字符的**最长子串**的长度。

```java
public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
        return s.length();
    }
    int[] winMap = new int[256];
    int left = 0;
    int right = 0;
    int maxLen = 0;
    // 1、右指针右移 
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        winMap[c]++;
        // 2、根据题意收缩窗口  
        while (winMap[c] > 1) {
            // 3、左指针右移更新窗口
            char d = s.charAt(left);
            left++;
            winMap[d]--;
        }
        // 4、根据题意计算结果
        maxLen = Math.max(right - left, maxLen);
    }
    return maxLen;
}
```

## 总结

- 和双指针题目类似，更像双指针的升级版，滑动窗口核心点是维护一个窗口集，根据窗口集来进行处理
- 核心步骤
  - right 右移
  - 收缩
  - left 右移
  - 求结果



# BinarySearch

## 简介

给一个**有序数组**和目标值，找第一次/最后一次/任何一次出现的索引，如果没有出现返回-1

模板四点要素

- 1、初始化：start=0、end=len-1
- 2、循环退出条件：start + 1 < end
- 3、比较中点和目标值：A[mid] ==、 <、> target
- 4、判断最后两个元素是否符合：A[start]、A[end] ? target

时间复杂度 O(logn)，使用场景一般是有序数组的查找

### 典型示例

> [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)
>
> 给定一个  n  个元素有序的（升序）整型数组  nums 和一个目标值  target  ，写一个函数搜索  nums  中的 target，如果目标值存在返回下标，否则返回 -1。

```java
// 二分搜索最常用模板
public int search(int[] nums, int target) {
    // 1、初始化left、right
    int left = 0;
    int right = nums.length - 1;
    // 2、处理for循环
    while (right - left > 1) {
        int mid = left + (right - left) / 2;
        // 3、比较nums[mid]和target值
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }
    // 4、最后剩下两个元素，手动判断
    if (nums[left] == target) {
        return left;
    } else if (nums[right] == target) {
        return right;
    } else {
        return -1;
    }
}
```

### 模板

大部分二分查找类的题目都可以用这个模板，然后做一点特殊逻辑即可

另外二分查找还有一些其他模板如下图，大部分场景模板#3 都能解决问题，而且还能找第一次/最后一次出现的位置，应用更加广泛

![binary_search_template](https://img.fuiboom.com/img/binary_search_template.png)

所以用模板#3 就对了，详细的对比可以这边文章介绍：[二分搜索模板](https://leetcode-cn.com/explore/learn/card/binary-search/212/template-analysis/847/)

如果是最简单的二分搜索，不需要找第一个、最后一个位置、或者是没有重复元素，可以使用模板#1，代码更简洁常见题目

## 常见题目

### 搜索插入位置

> [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)
>
> 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

```java
public int searchInsert(int[] nums, int target) {
    // 思路：找到第一个 >= target 的元素位置
    int left = 0;
    int right = nums.length - 1;
    while (right - left > 1) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }
    if (nums[left] >= target) {
        return left;
    } else if (nums[left] < target && target <= nums[right]) {
        return left + 1;
    } else {
        // 目标值比所有值都大
        return right + 1;
    }
}
```

### 搜索二维矩阵

> [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)
>
> 编写一个高效的算法来判断  m x n  矩阵中，是否存在一个目标值。该矩阵具有如下特性：
>
> - 每行中的整数从左到右按升序排列。
> - 每行的第一个整数大于前一行的最后一个整数。

```java
public boolean searchMatrix(int[][] matrix, int target) {
    // 思路：将2维数组转为1维数组 进行二分搜索
    if (matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    while (right - left > 1) {
        int mid = left + (right - left) / 2;
         // 获取2维数组对应值
        int val = matrix[mid/col][mid%col];
        if (val < target) {
            left = mid;
        } else if (val > target) {
            right = mid;
        } else {
            return true;
        }
    }
    if (matrix[left/col][left%col] == target || matrix[right/col][right%col] == target) {
        return true;
    }
    return false;
}
```

### 寻找旋转排序数组中的最小值

> [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
>
> 假设按照升序排序的数组在预先未知的某个点上进行了旋转( 例如，数组  [0,1,2,4,5,6,7] 可能变为  [4,5,6,7,0,1,2] )。
> 请找出其中最小的元素。

```java
public int findMin(int[] nums) {
    // 思路：最后一个值作为target，然后往左移动，最后比较start、end的值
    if (nums.length == 0) {
        return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (right - left > 1) {
        int mid = left + (right - left) / 2;
        // 最后一个元素值为target
        if (nums[mid] > nums[right]) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return Math.min(nums[left], nums[right]);
}
```

### 寻找旋转排序数组中的最小值 II

> [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)
>
> 假设按照升序排序的数组在预先未知的某个点上进行了旋转
> ( 例如，数组  [0,1,2,4,5,6,7] 可能变为  [4,5,6,7,0,1,2] )。
> 请找出其中最小的元素。(包含重复元素)

```java
public int findMin(int[] nums) {
    // 思路：跳过重复元素，mid值和end值比较，分为两种情况进行处理
    if (nums.length == 0) {
        return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (right - left > 1) {
        // 去除重复元素
        while (left < right && nums[right] == nums[right - 1]) {
            right--;
        }
        while (left < right && nums[left] == nums[left + 1]) {
            left++;
        }
        int mid = left + (right - left) / 2;
        // 中间元素和最后一个元素比较（判断中间点落在左边上升区，还是右边上升区）
        if (nums[mid] > nums[right]) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return Math.min(nums[left], nums[right]);
}
```

### 搜索旋转排序数组

> [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
>
> 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
> ( 例如，数组  [0,1,2,4,5,6,7]  可能变为  [4,5,6,7,0,1,2] )。
> 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回  -1 。
> 你可以假设数组中不存在重复的元素。

```java
public int search(int[] nums, int target) {
     // 思路：四种情况判断
    if (nums.length == 0) {
        return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (right - left > 1) {
        int mid = left + (right - left) / 2;
        // 相等直接返回
        if (nums[mid] == target) {
            return mid;
        }
        // 判断在哪个区间，可能分为四种情况
        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        } else if (nums[right] > nums[mid]) {
            if (nums[right] >= target && target >= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }
    if (nums[left] == target) {
        return left;
    } else if (nums[right] == target) {
        return right;
    }
    return -1;
}
```

注意点

> 面试时，可以直接画图进行辅助说明，空讲很容易让大家都比较蒙圈

### 搜索旋转排序数组 II

> [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)
>
> 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
> ( 例如，数组  [0,0,1,2,2,5,6]  可能变为  [2,5,6,0,0,1,2] )。
> 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回  true，否则返回  false。(包含重复元素)

```java
public boolean search(int[] nums, int target) {
     // 思路：四种情况判断
    if (nums.length == 0) {
        return false;
    }
    int left = 0;
    int right = nums.length - 1;
    while (right - left > 1) {
        // 去除重复元素
        while (left < right && nums[right] == nums[right - 1]) {
            right--;
        }
        while (left < right && nums[left] == nums[left + 1]) {
            left++;
        }
        int mid = left + (right - left) / 2;
        // 相等直接返回
        if (nums[mid] == target) {
            return true;
        }
        // 判断在哪个区间，可能分为四种情况
        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        } else if (nums[right] > nums[mid]) {
            if (nums[right] >= target && target >= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }
    return (nums[left] == target || nums[right] == target);
}
```

## 总结

二分搜索核心四点要素（必背&理解）

- 1、初始化：start=0、end=len-1
- 2、循环退出条件：start + 1 < end
- 3、比较中点和目标值：A[mid] ==、 <、> target
- 4、判断最后两个元素是否符合：A[start]、A[end] ? target

 # DisjointSet

## 简介

并查集用于处理不相交集合的合并与查询问题，常见操作有：

- 查询：查询元素属于哪个集合，可用于判断元素是否在一个集合中
- 合并：合并两个集合

应用场景：动态连通性的判断，且不需要给出具体路径。

## 数据结构

### 初始化

id数组存放的是节点的组号，初始化时将每个节点单独分为一组。

```java
private int[] id;

public DisjoinSet(int size) {
    id = new int[size];
    for(int i = 0; i < size; i++)
	    id[i] = i;
}
```

### Quick-Find

由于使用整数表示节点，可以通过数组实现节点到组编号的映射。

```java
public void union(int p, int q) { 
    // 获得p和q的组号
    int pID = id[p];
    int qID = id[q];
    // 如果两个组号相等，直接返回
    if (pID == qID) return;
    // 遍历一次，改变组号使他们属于一个组
    for (int i = 0; i < id.length; i++)
        if (id[i] == pID) id[i] = qID;
    count--;
}
```

### Quick-Union

id数组存放的是节点的父节点索引，根节点的父节点是自身，通过这点判断能到达根节点。

```java
private int find(int p) { 
	// 寻找p节点所在组的根节点，根节点具有性质id[root] = root
	while (p != id[p]) p = id[p];
	return p;
}
public void union(int p, int q) { 
	// Give p and q the same root.
	int pRoot = find(p);
	int qRoot = find(q);
	if (pRoot == qRoot) 
		return;
	// 将一棵树(即一个组)变成另外一课树(即一个组)的子树
	id[pRoot] = qRoot;    
	count--;
}
```

### Weighted Quick Union

保存两棵树的大小，每次将小的合并到大的树中。

## 常见例题

### 冗余连接

> [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)
>
> 在本问题中, 树指的是一个连通且无环的**无向**图。
>
> 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
>
> 结果图是一个以`边`组成的二维数组。每一个`边`的元素是一对`[u, v]` ，满足 `u < v`，表示连接顶点`u` 和`v`的**无向**图的边。
>
> 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 `[u, v]` 应满足相同的格式 `u < v`。

```java
private int[] parent;
private int[] size;

private int find(int p) {
    while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
    }
    return p;
}

private boolean union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    // 在合并前判断是否属于相同的连通分量
    if (pRoot == qRoot) {
        return true;
    }
    // Weighted Quick Union
    if (size[pRoot] < size[qRoot]) { 
        parent[pRoot] = qRoot; 
        size[qRoot] += size[pRoot]; 
    } else { 
        parent[qRoot] = pRoot; 
        size[pRoot] += size[qRoot]; 
    }
    return false;
}

public int[] findRedundantConnection(int[][] edges) {
    parent = new int[edges.length + 1];
    size = new int[edges.length + 1];
    // 并查集初始化
    for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    for (int[] arr : edges) {
        if (union(arr[0], arr[1])) {
            // 如果已经连通说明当前这条边是多余的
            return arr;
        }
    }
    return new int[]{};
}
```

### 打砖块

> [803. 打砖块](https://leetcode-cn.com/problems/bricks-falling-when-hit/)
>
> 有一个 `m x n` 的二元网格，其中 `1` 表示砖块，`0` 表示空白。砖块 **稳定**（不会掉落）的前提是：
>
> - 一块砖直接连接到网格的顶部，或者
> - 至少有一块相邻（4 个方向之一）砖块 **稳定** 不会掉落时
>
> 给你一个数组 `hits` ，这是需要依次消除砖块的位置。每当消除 `hits[i] = (rowi, coli)` 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
>
> 返回一个数组 `result` ，其中 `result[i]` 表示第 `i` 次消除操作对应掉落的砖块数目。
>
> **注意**，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。

思路：并查集是用于合并连通分量，而砖块消失实质上是拆分连通分量，因此这题应当逆向考虑，即先打碎所有砖块，再从后向前添加砖块（合并连通分量），添加后计算会增加多少个节点与根节点相连。

首先给出并查集的定义，`size`既表示连通分量的大小，也用于合并时的权重判断。

```java
class DisJoinSet {

    private final int[] parent;
    private final int[] size;

    // 初始化并查集，根节点为自身，大小为1
    public DisJoinSet(int len) {
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 查找连通分量的根节点
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    // 合并两个节点对应的连通分量
    public void merge(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        // 在合并前判断是否属于相同的连通分量
        if (pRoot != qRoot) {
            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }
    }

    // 获取连通分量的大小
    public int getSize(int n) {
        int root = find(n);
        return size[root];
    }

}
```

实际使用中将二维数组映射为一维数组，并在最后增加一项作为“房顶节点”，与其相连的节点均不会下落。下面是算法逻辑：

```java
public int[] hitBricks(int[][] grid, int[][] hits) {
    int h = grid.length;
    int w = grid[0].length;
    int[] result = new int[hits.length];
    // 保存当前的砖块状态
    int[][] status = new int[h][w];
    DisJoinSet disJoinSet = new DisJoinSet(h * w + 1);
    // 将status初始化为最终的状态
    for (int i = 0; i < h; i++) {
        status[i] = grid[i].clone();
    }
    for (int[] pos : hits) {
        status[pos[0]][pos[1]] = 0;
    }
    // 根据最后的状态构造并查集
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (status[i][j] == 0) {
                continue;
            }
            if (i == 0) {
                // 一块砖直接连接到网格的顶部
                disJoinSet.merge( h * w, j);
            } else {
                // 上方有相邻砖块
                if (status[i - 1][j] == 1) {
                    disJoinSet.merge((i - 1) * w + j, i * w + j);
                }
                // 左侧有相邻砖块
                if (j > 0 && status[i][j - 1] == 1) {
                    disJoinSet.merge(i * w + j - 1, i * w + j);
                }
            }
        }
    }
    // 从后向前把砖块补上
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    for (int i = hits.length - 1; i >= 0; i--) {
        int r = hits[i][0];
        int c = hits[i][1];
        if (grid[r][c] == 0) {
            result[i] = 0;
        } else {
            // 添加砖块前与房顶相连通的节点数目
            int prev = disJoinSet.getSize(h * w);
            // 顶部第一行的情况
            if (r == 0) {
                disJoinSet.merge(c, h * w);
            }
            // 处理四周的节点
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w && status[nr][nc] == 1) {
                    disJoinSet.merge(r * w + c, nr * w + nc);
                }
            }
            // 获得增加的节点数，即为正向操作时这一步下落的节点数
            result[i] = Math.max(0, disJoinSet.getSize(h * w) - prev - 1);
            status[r][c] = 1;
        }
    }
    return result;
}
```

# BinaryTree

## 二叉树遍历

**前序遍历**：[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

先访问根节点，再前序遍历左子树，再前序遍历右子树

**中序遍历**：[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

先中序遍历左子树，再访问根节点，再中序遍历右子树

**后序遍历**：[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

先后序遍历左子树，再后序遍历右子树，再访问根节点

注意点

- 以根访问顺序决定是什么遍历
- 左子树都比右子树优先遍历

### 递归遍历

```java
// 递归遍历写法，以前序遍历为例
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    traverse(root, result);
    return result;
}

public void traverse(TreeNode p, List<Integer> result) {
    if (p == null) {
        return;
    }
    // 其他遍历调整这里的语句顺序即可
    result.add(p.val);
    traverse(p.left, result);
    traverse(p.right, result);
}
```

### 前序非递归

```java
// 通过非递归遍历
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (p != null || ! stack.isEmpty()) {
        while (p != null) {
            // 前序遍历，所以先保存结果
            result.add(p.val);
            stack.push(p);
            p = p.left;
        }
        // pop出栈顶元素
        if (! stack.isEmpty()) {
            p = stack.pop();
            p = p.right;
        }
    }
    return result;
}
```

### 中序非递归

```java
// 思路：通过stack 保存已经访问的元素，用于原路返回
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (p != null || ! stack.isEmpty()) {
        if (p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);
            p = node.right;
        }
    }
    return result;
}
```

### 后序非递归

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    // 通过lastVisit标识右子节点是否已经弹出
    TreeNode lastVisit = root;
    while (p != null || !stack.isEmpty()) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        //查看当前栈顶元素
        p = stack.peek();
        //如果其右子树也为空，或者右子树已经访问，则可以访问
        if (p.right == null || p.right == lastVisit) {
            result.add(p.val);
            stack.pop();
            // 标记当前这个节点已经弹出过
            lastVisit = p;
            p = null;
        } else {
            //否则继续遍历右子树
            p = p.right;
        }
    }
    return result;
}
```

注意点

- 核心就是：根节点必须在右节点弹出之后，再弹出

### DFS 深度搜索

> [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)
>
> 给定一个二叉树，返回所有从根节点到叶子节点的路径。

```java
public List<String> binaryTreePaths(TreeNode root) {
    StringBuilder path = new StringBuilder();
    List<String> paths = new LinkedList<>();
    dfs(root, path, paths);
    return paths;
}

public void dfs(TreeNode p, StringBuilder path, List<String> paths) {
    if (p == null) {
        return;
    }
    path.append(p.val);
    // 当前节点是叶子节点
    if (p.left == null && p.right == null) {
         // 把路径加入结果
        paths.add(path.toString());
    } else {
        path.append("->");
        // 这里需要复制创建新的StringBuilder对象
        dfs(p.left, new StringBuilder(path), paths);
        dfs(p.right, new StringBuilder(path), paths);
    }
}
```

### BFS 层次遍历

```java
public List<Integer> levelOrder(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) {
        return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode p = queue.pop();
        result.add(p);
        if (p.left != null) {
            queue.add(p.left);
            numList.add(p.left.val);
        }
        if (p.right != null) {
            queue.add(p.right);
            numList.add(p.right.val);
        }
    }
    return result
}
```

## 二叉树分治

先分别处理局部，再合并结果

分治法模板

- 递归返回条件
- 分段处理
- 合并结果

```java
public ResultType traversal(TreeNode root) {
    // null or leaf
    if (root == null) {
        // do something and return
    }
    // Divide
    ResultType left = traversal(root.Left)
    ResultType right = traversal(root.Right)
    // Conquer
    ResultType result = Merge from left and right
    return result
}
```

### 典型示例

> [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)
>
> 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

```java
public boolean isValidBST(TreeNode root) {
    return divideAndConquer(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean divideAndConquer(TreeNode p, long min, long max) {
    if (p == null) return true;
    // 返回条件
    if (p.val <= min || max <= p.val) {
        return false;
    }
    // 分治(Divide)
    boolean left = divideAndConquer(p.left, min, p.val);
    boolean right = divideAndConquer(p.right, p.val, max);
    // 合并结果(Conquer)
    return left && right;
}
```

注意点：

> DFS 深度搜索（从上到下） 和分治法区别：前者一般将最终结果通过参数传入，后者一般递归返回结果最后合并

### 常见题目

#### 二叉树的最大深度

> [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
>
> 给定一个二叉树，找出其最大深度。
>
> 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

思路：分治法

```java
public int maxDepth(TreeNode root) {
    // 返回条件处理
    if (root == null) {
        return 0;
    }
    // divide：分左右子树分别计算
    // conquer：合并左右子树结果，即取二者中的最大值加一
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
```

#### 平衡二叉树

> [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)
>
> 给定一个二叉树，判断它是否是高度平衡的二叉树。

思路：分治法，左边平衡 && 右边平衡 && 左右两边高度 <= 1，因为需要返回是否平衡及高度，要么返回两个数据，要么合并两个数据，所以用-1 表示不平衡，>0 表示树高度（二义性：一个变量有两种含义）。

```java
public boolean isBalanced(TreeNode root) {
    return maxDepth(root) >= 0;
}

private int maxDepth(TreeNode p) {
    if (p == null) {
        return 0;
    }
    int left = maxDepth(p.left);
    int right = maxDepth(p.right);
    if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
        return -1;
    } else {
        return Math.max(left, right) + 1;
    }
}
```

注意

> 一般工程中，结果通过两个变量来返回，不建议用一个变量表示两种含义

#### 二叉树中的最大路径和

> [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
>
> **路径** 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 **至多出现一次** 。该路径 **至少包含一个** 节点，且不一定经过根节点。
>
> **路径和** 是路径中各节点值的总和。
>
> 给你一个二叉树的根节点 `root` ，返回其 **最大路径和** 。

思路：分治法，分为三种情况：左子树最大路径和最大，右子树最大路径和最大，左右子树最大加根节点最大，需要保存两个变量：一个保存子树最大路径和，一个保存左右加根节点和，然后比较这个两个变量选择最大值即可

```java
public int maxPathSum(TreeNode root) {
    return maxSum(root)[1];
}

// 返回的数组意义：int[0]表示单边最大值，int[1]表示所有情况的最大值（单边或者两个单边+根的值）
private int[] maxSum(TreeNode p) {
    // check
    if (p == null) {
        return new int[]{0, Integer.MIN_VALUE};
    }
    // Divide
    int[] left = maxSum(p.left);
    int[] right = maxSum(p.right);
    int singleSum, bothSum;
    // Conquer
    // 求单边最大值
    if (left[0] > right[0]) {
        singleSum = Math.max(left[0] + p.val, 0);
    } else {
        singleSum = Math.max(right[0] + p.val, 0);
    }
    // 求所有情况（两个子树的所有情况、两个单边最大值与根之和）的最大值
    bothSum = Math.max(left[1], right[1]);
    bothSum = Math.max(bothSum, left[0] + right[0] + p.val);
    return new int[]{singleSum, bothSum};
}
```

#### 二叉树的最近公共祖先

> [235. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
>
> 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

思路：分治法，有左子树的公共祖先或者有右子树的公共祖先，就返回子树的祖先，否则返回根节点

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // check
    if (root == null) {
        return null;
    }
    // 相等 直接返回root节点即可
    if (root == p || root == q) {
        return root;
    }
    // Divide
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // Conquer
    // 左右两边都不为空，则根节点为祖先
    if (left != null && right != null) {
        return root;
    } else if (left != null) {
        return left;
    } else {
        return right;
    }
}
```

## BFS 应用

### 常见题目

#### 二叉树的层序遍历

> [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
>
> 给你一个二叉树，请你返回其按  **层序遍历**  得到的节点值。 （即逐层地，从左到右访问所有节点）

思路：用一个队列记录一层的元素，然后扫描这一层元素添加下一层元素到队列（一个数进去出来一次，所以复杂度 O(logN)）

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) {
        return result;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<Integer> numList = new LinkedList<>();
    queue.add(root);
    numList.add(root.val);
    while (! queue.isEmpty()) {
        // 保存这一层的元素
        result.add(numList);
        numList = new LinkedList<>();
        // 记录当前层有多少元素（遍历当前层，再添加下一层）
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            // 出队列
            TreeNode p = queue.pop();
            if (p.left != null) {
                queue.add(p.left);
                numList.add(p.left.val);
            }
            if (p.right != null) {
                queue.add(p.right);
                numList.add(p.right.val);
            }
        }
    }
    return result;
}
```

#### 二叉树的层序遍历 II

> [107. 二叉树的层序遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
>
> 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

思路：在层级遍历的基础上，翻转一下结果即可，在往result内添加元素之前使用`Collections.reverse`方法翻转列表。

#### 二叉树的锯齿形层序遍历

> [103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
>
> 给定一个二叉树，返回其节点值的锯齿形层次遍历。Z 字形遍历

思路：在层级遍历的基础上，判断这一层是否需要翻转，在往result内添加元素之前加入以下代码：

```java
if (result.size() % 2 != 0) {
    Collections.reverse(numList);
}
```

## 二叉搜索树应用

### 常见题目

#### 二叉搜索树中的插入操作

> [701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
>
> 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。

思路：找到最后一个叶子节点满足插入条件即可

```java
// DFS查找插入位置
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    if (root.val > val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }
    return root;
}
```

## 总结

- 掌握二叉树递归与非递归遍历
- 理解 DFS 前序遍历与分治法
- 理解 BFS 层次遍历

# LinkedList

## 提纲

链表相关的核心点

- null 异常处理
- dummy node 哑巴节点
- 快慢指针
- 插入一个节点到排序链表
- 从一个链表中移除一个节点
- 翻转链表
- 合并两个链表
- 找到链表的中间节点

## 基本操作

### 链表删除

#### 删除排序链表中的重复元素

> [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
>
> 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

```java
public ListNode deleteDuplicates(ListNode head) {
    ListNode p = head;
    while (p != null) {
        // 全部删除完再移动到下一个元素
        while (p.next != null && p.val == p.next.val) {
            p.next = p.next.next;
        }
        p = p.next;
    }
    return head;
}
```

#### 删除排序链表中的重复元素 II

> [82. 删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)
>
> 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中   没有重复出现的数字。

思路：链表头结点可能被删除，所以用 dummy node 辅助删除

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode newHead = new ListNode(-1, head);
    ListNode p = newHead;
    int n = 0;
    while (p.next != null && p.next.next != null) {
        if (p.next.val == p.next.next.val) {
            // 记录已经删除的值，用于后续节点判断
            n = p.next.val;
            while (p.next != null && p.next.val == n) {
                p.next = p.next.next;
            }
        } else {
            p = p.next;
        }
    }
    return newHead.next;
}
```

注意点

- A->B->C 删除 B，A.next = C
- 删除用一个 Dummy Node 节点辅助（允许头节点可变）
- 访问 X.next 、X.value 一定要保证 X != nil

### 链表反转

#### 反转链表

> [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
>
> 反转一个单链表。

思路：用一个 prev 节点保存向前指针，temp 保存向后的临时指针

```java
public ListNode reverseList(ListNode head) {
    ListNode pre = null, p = head;
    while (p != null) {
        // 保存当前head.Next节点，防止重新赋值后被覆盖
        // 一轮之后状态：nil<-1 2->3->4
        //               prev p
        ListNode temp = p.next;
        p.next = pre;
        // pre 移动
        pre = p;
        // p 移动
        p = temp;
    }
    return pre;
}
```

#### 反转链表 II

> [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
>
> 反转从位置  *m*  到  *n*  的链表。请使用一趟扫描完成反转。

思路：先遍历到 m 处，翻转，再拼接后续，注意指针处理

```java
public ListNode reverseBetween(ListNode head, int m, int n) {
    // 思路：先遍历到m处，翻转，再拼接后续，注意指针处理
    // 输入: 1->2->3->4->5->null, m = 2, n = 4
    ListNode newHead = new ListNode(0, head);
    ListNode p = newHead;
    // 最开始：0(p)->1->2->3->4->5->null
    for (int i = 0; i < m-1; i++) {
        p = p.next;
    }
    // 遍历之后： 0->1(p)->2(cur)->3->4->5->null
    ListNode pre = null;
    ListNode cur = p.next;
    for (int i = m; i <= n; i++) {
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    // 循环结束：0->1(p)->2->null 5(cur)->null 4(pre)->3->2->null
    p.next.next = cur;
    p.next = pre;
    return newHead.next;
}
```

### 链表合并

#### 合并两个有序链表

> [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
>
> 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

思路：通过 dummy node 链表，连接各个元素

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            p.next = l1;
            l1 = l1.next;
        } else {
            p.next = l2;
            l2 = l2.next;
        }
        p = p.next;
    }
    // 连接未处理完节点
    p.next = l1 == null ? l2 : l1;
    return head.next;
}
```

####  合并K个升序链表

> [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
>
> 给你一个链表数组，每个链表都已经按升序排列。
>
> 请你将所有链表合并到一个升序链表中，返回合并后的链表。

思路：使用分治的方法两个两个地合并链表

```java
public ListNode mergeKLists(ListNode[] lists) {
    return merge(lists, 0, lists.length - 1);
}

public ListNode merge(ListNode[] lists, int begin, int end) {
    if (begin == end) return lists[begin];
    if (begin > end) return null;
    int mid = (begin + end) >> 1;
    return mergeTwoLists(merge(lists, begin, mid), merge(lists, mid + 1, end));
}

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 同上
}
```

## 快慢指针

### 链表中点

使用两个指针变量，慢指针每次前进一步，快指针每次前进两步。这样当快指针到达链表末尾时，慢指针恰好在链表的中间位置。要注意链表长度为偶数的情况。

> [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)
>
> 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
>
> 如果有两个中间结点，则返回第二个中间结点。

```java
public ListNode middleNode(ListNode head) {
    ListNode p = head;
    ListNode q = head;
    while (q != null && q.next != null) {
        p = p.next;
        q = q.next.next;
    }
    return p;
}
```

#### 重排链表

> [143. 重排链表](https://leetcode-cn.com/problems/reorder-list/)
> 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
>
> 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
>
> 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 

```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    // 通过快慢指针找中点
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode p = head;
    // 反转链表
    ListNode q = reverseList(slow.next);
    slow.next = null;
    while (p != null && q != null) {
        ListNode qNext = q.next;
        q.next = p.next;
        p.next = q;
        p = q.next;
        q = qNext;
    }
}
```


#### 回文链表

> [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)
>
> 请判断一个链表是否为回文链表。

```java
public boolean isPalindrome(ListNode head) {
     // fast如果初始化为head.Next则中点在slow.Next
    // fast初始化为head,则中点在slow
    ListNode slow = head, fast = head, pre = null;
    // 这里顺便做了反转链表的操作
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        ListNode next = slow.next;
        slow.next = pre;
        pre = slow;
        slow = next;
    }
    if (fast != null){
        slow = slow.next;
    }
    // 与另一半链表依次比较
    while (slow != null) {
        if (slow.val != pre.val) return false;
        slow = slow.next;
        pre = pre.next;
    }
    return true;
}
```


### 结构判断

#### 环形链表

> [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
>
> 给定一个链表，判断链表中是否有环。
>
> 如果链表中存在环，则返回 `true`。 否则，返回`false`。

思路：快慢指针，快慢指针相同则有环，证明：如果有环每走一步快慢指针距离会减 1
![fast_slow_linked_list](https://img.fuiboom.com/img/fast_slow_linked_list.png)

```java
public boolean hasCycle(ListNode head) {
    ListNode p = head, q = head;
    // 思路：快慢指针 快慢指针相同则有环，证明：如果有环每走一步快慢指针距离会减1
    while (p != null && q != null && q.next != null) {
        p = p.next;
        q = q.next.next;
        // 比较指针是否相等（不要使用val比较）
        if (p == q) {
            return true;
        }
    }
    return false;
}
```

#### 环形链表 II

> [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
>
> 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 `null`。

思路：快慢指针，快慢相遇之后，慢指针回到头，快慢指针步调一致一起移动，相遇点即为入环点
![cycled_linked_list](https://img.fuiboom.com/img/cycled_linked_list.png)

```java
public ListNode detectCycle(ListNode head) {
    // 思路：快慢指针，快慢相遇之后，慢指针回到头，快慢指针步调一致一起移动，相遇点即为入环点
    ListNode p = head, q = head;
    while (p != null && q != null && q.next != null) {
        p = p.next;
        q = q.next.next;
        if (p == q) {
            // 指针重新从头开始移动
            ListNode m = head;
            // 比较指针对象（不要比对指针Val值）
            while (m != p) {
                m = m.next;
                p = p.next;
            }
            return p;
        }
    }
    return null;
}
```

## 其他

> [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
>
> 给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。(尝试使用一趟扫描实现)

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode newHead = new ListNode(0, head);
    ListNode p1 = newHead;
    ListNode p2 = newHead;
    // 提前前进n个位置
    while (n >= 0) {
        p2 = p2.next;
        n--;
    }
    while (p2 != null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    p1.next = p1.next.next;
    return newHead.next;
}
```

> [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)
>
> 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
>
> 要求返回这个链表的 深拷贝。

思路：1、hash 表存储指针，2、复制节点跟在原节点后面

```java
public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }
	// 复制节点，紧挨到到后面
	// 1->2->3  ==>  1->1'->2->2'->3->3'
    Node cur = head;
    while (cur != null) {
        Node cloneNode = new Node(cur.val);
        cloneNode.next = cur.next;
        Node temp = cur.next;
        cur.next = cloneNode;
        cur = temp;
    }
    // 处理random指针
    cur = head;
    while (cur != null) {
        if (cur.random != null) {
            cur.next.random = cur.random.next;
        }
        cur = cur.next.next;
    }
    // 分离两个链表
    cur = head;
    Node cloneHead = cur.next;
    while (cur != null && cur.next != null) {
        Node temp = cur.next;
        cur.next = cur.next.next;
        cur = temp;
    }
	// 原始链表头：head 1->2->3
	// 克隆的链表头：cloneHead 1'->2'->3'
    return cloneHead;
}
```

## 总结

链表必须要掌握的一些点，通过下面练习题，基本大部分的链表类的题目都是手到擒来~

- null 异常处理
- dummy node 哑巴节点
- 快慢指针
- 插入一个节点到排序链表
- 从一个链表中移除一个节点
- 翻转链表
- 合并两个链表
- 找到链表的中间节点
- 链表的末尾指针最后指向null

 # StackQueue

## 简介

栈的特点是后入先出

根据这个特点可以临时保存一些数据，之后用到依次再弹出来，常用于树的非递归遍历、 DFS 深度搜索。

队列常用于BFS广度搜索，很少单独考察。

## 基本应用

### 逆波兰表达式求值

> [150. 逆波兰表达式求值](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)
>
> **波兰表达式计算** > **输入:** `["2", "1", "+", "3", "*"]` > **输出:** 9
>
> **解释:** `((2 + 1) * 3) = 9`

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String s : tokens) {
        if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
            int a = stack.pop();
            int b = stack.pop();
            if ("+".equals(s)) stack.push(b + a);
            else if ("-".equals(s)) stack.push(b - a);
            else if ("*".equals(s)) stack.push(b * a);
            // 注意：b为被除数，a为除数
            else if ("/".equals(s)) stack.push(b / a);
        } else {
            // 转为数字
            stack.push(Integer.parseInt(s));
        }
    }
    return stack.pop();
}
```

### 有效的括号

> [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
>
> 给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串 `s` ，判断字符串是否有效。
>
> 有效字符串需满足：
>
> 1. 左括号必须用相同类型的右括号闭合。
> 2. 左括号必须以正确的顺序闭合。

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(') stack.push(')');
        else if (c == '[') stack.push(']');
        else if (c == '{') stack.push('}');
        else if (stack.isEmpty() || c != stack.pop()) {
            return false;
        }
    }
    return stack.isEmpty();
}
```

## 单调栈

单调栈：栈内元素保持单调递增或单调递减的栈

**（以单调递增栈为例）**

入栈规则：

- 新元素比栈顶元素小：直接入栈

- 新元素比栈顶元素大：弹出栈内元素直到栈顶比新元素小（或空栈）

出栈意义：

- 需要出栈时，入栈的新元素是出栈元素右方第一个比出栈元素小的元素

- 出栈后，新的栈顶是出栈元素左侧最大的数

技巧：最后添加一个值为0的哨兵节点，可以在最后强制所有元素出栈。

以下分别使用了单调递增栈和单调递减栈

### 柱状图中最大的矩形

> [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)
>
> 给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
>
> 求在该柱状图中，能够勾勒出来的矩形的最大面积。

```java
public int largestRectangleArea(int[] heights) {
    if (heights.length == 0) {
        return 0;
    }
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    // 当前高度小于栈，则将栈内元素都弹出计算面积
    for (int i = 0; i <= heights.length; i++) {
        int cur = 0;
        if (i < heights.length) {
            cur = heights[i];
        }
        while (stack.size() != 0 && cur <= heights[stack.peek()]) {
            int index = stack.pop();
            int h = heights[index];
            // 计算宽度
            int w = i;
            if (stack.size() != 0) {
                int peek = stack.peek();
                w = i - peek - 1;
            }
            max = Math.max(max, h * w);
        }
         // 记录索引即可获取对应元素
        stack.push(i);
    }
    return max;
}
```

### 接雨水

> [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)
>
> 给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

```java
public int trap(int[] height) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    int current = 0;
    while (current < height.length) {
        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        while (!stack.empty() && height[current] > height[stack.peek()]) {
            int h = height[stack.peek()]; //取出要出栈的元素
            stack.pop(); //出栈
            if (stack.empty()) { // 栈空就出去
                break;
            }
            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
            int min = Math.min(height[stack.peek()], height[current]);
            sum = sum + distance * (min - h);
        }
        stack.push(current); //当前指向的墙入栈
        current++; //指针后移
    }
    return sum;
}
```

## 设计类问题

> [2. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/)

```java
class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (! stack2.isEmpty()) {
            int val = stack2.pop();
            stack1.push(val);
        }
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (! stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        if (stack2.isEmpty()) return -1;
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         while (! stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        if (stack2.isEmpty()) return -1;
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
```

