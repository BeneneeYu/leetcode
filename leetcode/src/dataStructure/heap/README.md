# Use Case

- Find the maximum/minimum value
- Find the $k^{th}$ largest element (pop k times, $O(nlogk)$)
- Operate data in $O(logn)$

## What heap can not do

- Find the nearest number to a number (should use **Balanced Sorted Tree**)
- Find the maximum/minimum value in a section (should use **Segament Tree**)
- Find the $k^{th}$ largest element in $O(n)$ (should use **Partition** in Quick Sort)

# Heap

```Java
class ValueIndexPair{
	int val, index;
}

class Heap{
	private Queue<ValueIndexPair> minHeap;
    private Set<Integer> deleteSet;
    public Heap(){
        minHeap = new PriorityQueue<>((p1, p2) -> (p1.val - p2.val));
        deleteSet = new HashSet<>();
    }
    
    public void push(int index, int val){
        minHeap.add(new ValueIndexPair(val, index));
    }
    
    private void lazyDeletion(){
        // delete when meet
        while(minHeap.size() != 0 && deleteSet.contains(minHeap.peek().index)){
            ValueIndexPair pair = minHeap.poll();
            deleteSet.remove(pair.index);
        }
    }
    
    public ValueIndexPair top(){
        lazyDeletion();
        return minHeap.peek();
    }
    
    public void pop(){
        lazyDeletion();
        minHeap.poll();
    }
    
    public void delete(int index){
        deleteSet.add(index);
    }
    
    private boolean isEmpty(){
        return minHeap.size() == 0;
    }
}
```

