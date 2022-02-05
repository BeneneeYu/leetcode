package dataStructure.complexDataStructure.question460;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-01-28 12:00
 **/
/*
LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 */
public class LFUCache {
//    public LFUCache(int capacity) {
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
    public static void main(String[] args) {
//        // cnt(x) = the use counter for key x
//        // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
//        LFUCache lfu = new LFUCache(2);
//        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//        lfu.get(1);      // return 1
//        // cache=[1,2], cnt(2)=1, cnt(1)=2
//        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        lfu.get(2);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//        // cache=[4,3], cnt(4)=1, cnt(3)=2
//        lfu.get(1);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,4], cnt(4)=1, cnt(3)=3
//        lfu.get(4);      // return 4
//        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
