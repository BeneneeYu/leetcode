package dataStructure.complexDataStructure.question146;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: Least Recently Used, a replacement algorithm
 * @author: Shen Zhengyu
 * @create: 2022-01-28 12:00
 **/
/*

 */
class LRUCache {

    // The node class of nodes in double linked list.
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // The actual structure that save the value data.
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    // Construct the double linked list that enables the replacement.
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // dummy node, notice, this will save a lot of verifying work
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode resultNode = cache.get(key);
        if (null == resultNode) return -1;
        moveToHead(resultNode);
        return resultNode.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            if (size >= capacity){
                cache.remove(getActualTail().key);
                deleteTail();
                size--;
            }
            DLinkedNode nodeToAdd = new DLinkedNode(key, value);
            addToHead(nodeToAdd);
            cache.put(key, nodeToAdd);
            size++;
        }
    }

    public void addToHead(DLinkedNode node){
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }
    public void deleteNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DLinkedNode getActualTail(){
        return tail.prev;
    }
    public void deleteTail(){
        deleteNode(tail.prev);
    }
    public void moveToHead(DLinkedNode node){
        deleteNode(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */