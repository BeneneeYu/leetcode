package dataStructure.complexDataStructure.question460;

import dataStructure.complexDataStructure.question146.LRUCache;

import java.util.HashMap;

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
    // The node class of nodes in double linked list.
    class DLinkedNode {
        int key;
        int value;
        int frequency;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value, int _frequency) {
            key = _key;
            value = _value;
            frequency = _frequency;
        }

        public DLinkedNode(int _key, int _value, int _frequency, DLinkedNode _prev, DLinkedNode _next) {
            key = _key;
            value = _value;
            frequency = _frequency;
            prev = _prev;
            next = _next;
        }
    }

    class DLinkedList {
        DLinkedNode head;
        DLinkedNode tail;

        public DLinkedList() {
            this.head = new DLinkedNode(-1, -1, -1, null, null);
            this.tail = new DLinkedNode(-1, -1, -1, null, null);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        boolean isEmpty() {
            return this.head.next == this.tail;
        }

        // insert to head
        void insertNode(DLinkedNode node) {
            if (null != node) {
                node.next = this.head.next;
                this.head.next.prev = node;
                node.prev = this.head;
                this.head.next = node;
            }
        }

        void deleteNode(DLinkedNode node) {
            if (null != node) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                node.prev = null;
                node.next = null;
            }
        }

        DLinkedNode getLastNode() {
            if (isEmpty()) {
                return new DLinkedNode(-1, -1, -1, null, null);
            }
            return this.tail.prev;
        }

    }

    HashMap<Integer, DLinkedNode> kvMap = new HashMap<>();
    HashMap<Integer, DLinkedList> freqMap = new HashMap<>();
    int size;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (kvMap.containsKey(key)) {
            DLinkedNode node = kvMap.get(key);
            increment(node, false);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)){
            DLinkedNode node = kvMap.get(key);
            node.value = value;
            increment(node, false);
        }else{
            if (capacity == 0){
                return;
            }
            if (kvMap.size() >= capacity){
                deleteLeastFrequentUsedNode();
            }
            DLinkedNode node = new DLinkedNode(key, value, 1);
            increment(node, true);
            kvMap.put(key, node);
        }
    }

    private void increment(DLinkedNode node, boolean isNewNode){
        if (isNewNode){
            this.minFreq = 1;
            this.insertToLinkedList(node);
        }else{
            this.deleteFromLinkedList(node);
            node.frequency += 1;
            this.insertToLinkedList(node);
            if (!freqMap.containsKey(minFreq)){
                minFreq++;
            }
        }
    }

    private void insertToLinkedList(DLinkedNode node){
        if (!this.freqMap.containsKey(node.frequency)){
            this.freqMap.put(node.frequency, new DLinkedList());
        }
        DLinkedList list = freqMap.get(node.frequency);
        list.insertNode(node);
    }

    private void deleteFromLinkedList(DLinkedNode node){
        DLinkedList list = freqMap.get(node.frequency);
        list.deleteNode(node);
        if (list.isEmpty()){
            this.freqMap.remove(node.frequency);
        }
    }

    private void deleteLeastFrequentUsedNode(){
        DLinkedList linkedList = freqMap.get(minFreq);
        DLinkedNode node = linkedList.getLastNode();
        linkedList.deleteNode(node);
        kvMap.remove(node.key);
        if (linkedList.isEmpty()){
            freqMap.remove(node.frequency);
        }

    }

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
