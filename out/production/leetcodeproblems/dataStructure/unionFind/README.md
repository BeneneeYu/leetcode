# Concept

A **disjoint-set data structure**, also called a **union–find data structure** or **merge–find set**, is a data structure that stores a collection of disjoint(non-overlapping) sets. Equivalently, it stores a partition of a set into disjoint subsets. It provides operations for adding new sets, merging sets (replacing them by their union, and finding a representative member of a set. The last operation makes it possible to find out efficiently if any two elements are in the same or different sets.

While there are several ways of implementing disjoint-set data structures, in practice they are often identified with a particular implementation called a **disjoint-set forest**. This is a specialized type of forest which performs unions and finds in near-constant amortized time. To perform a sequence of *m* addition, union, or find operations on a disjoint-set forest with *n* nodes requires total time [*O*](https://en.wikipedia.org/wiki/Big_O_notation)(*m*α(*n*)). Disjoint-set forests do not guarantee this performance on a per-operation basis. Individual union and find operations can take longer than a constant times α(*n*) time, but each operation causes the disjoint-set forest to adjust itself so that successive operations are faster. Disjoint-set forests are both asymptotically optimal and practically efficient.

Disjoint-set data structures play a key role in Kruskal's algorithm for finding the minimum spanning tree of a graph.

# Use Case

- To find out the connectivity of Graphs(Connected subgraph)
- To find the minimum spanning tree by Kruskal Algorithm
- To find LCA(least closest ancestor)
- To merge two sets quickly

## Complexity

Time: $O(1)$

Space: $O(n)$

# Operation

## initiate

1. Use array fa[] to store the father node of every element, firstly, the father node is itself

## find

1. find `i`'s ancestor/ representative element
2. use recursion (return find(fa[i])), compress the path(cut the father-son relationship)

For union-find, relative relationship is not the important, if two nodes are in the same set is important.

## union

1. find `i`'s ancestor
2. find `j`'s ancestor
3. make `i`'s ancestor point at `j`'s ancestor

# Template

init, find and union

```java
class UnionFind{
	private Map<Integer, Integer> father; // store the node-father relationship
	private Map<Integer, Integer> sizeOfSet; // store the root-size relationship
    private int numOfSet = 0;
    public UnionFind(){
        // initialize the father pointer, size of set, number of set
        father = new HashMap<Integer, Integer>();
        sizeOfSet = new HashMap<Integer, Integer>();
        numOfSet = 0;
    }
    
    public void add(int x){
        // already exist
        if(father.containsKey(x)){
            return;
        }
        // initialize the father of node is null, the size of set holding the element as 1, the number of size increase by 1
        father.put(x, null);
        sizeOfSet.put(x, 1);
        numOfSet += 1;
        // it becomes the new root
    }
    
    // merge the two sets which contain x or y
    public void merge(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            // let the root of Y be the new root
            father.put(rootX, rootY);
            numOfSet -= 1;
            sizeOfSet.put(rootY, sizeOfSet.get(rootX) + sizeOfSet.get(rootY));
        }
    }
    
    public int find(int x){
        int root = x;
        //find father of root continuously until root points at a root node
        while(father.get(root) != null){
            root = father.get(root);
        }
        // update the father node of every node in path
        while(x != root){
            int originalFather = father.get(x);
            father.put(x, root); 
            x = originalFather;
        }
        return root;
    }
    
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    public int getNumOfSet(){
        return numOfSet;
    }
    
    public int getSizeOfSet(int x){
        return sizeOfSet.get(find(x));
    }
}
```

