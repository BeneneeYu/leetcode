package dataStructure.hash.question706;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: Design a HashMap without using any built-in hash table libraries.
 * @author: Shen Zhengyu
 * @create: 2022-02-16 16:19
 **/
public class MyHashMap {
    // 0 <= key, value <= 10^6
    private class KeyValuePair {
        int key;
        int val;

        public KeyValuePair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    // BASE for hash mapping
    private static final int BASE = 769;
    private LinkedList<KeyValuePair>[] data;

    // MyHashMap() initializes the object with an empty map.
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<KeyValuePair>();
        }
    }

    // void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
    public void put(int key, int value) {
        int h = hash(key);
        LinkedList<KeyValuePair> hList = data[h];
        for (KeyValuePair keyValuePair : hList) {
            if (keyValuePair.getKey() == key){
                keyValuePair.val = value;
                return;
            }
        }
        hList.addLast(new KeyValuePair(key, value));
    }

    // int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    public int get(int key) {
        int h = hash(key);
        LinkedList<KeyValuePair> hList = data[h];
        for (KeyValuePair keyValuePair : hList) {
            if (keyValuePair.getKey() == key){
                return keyValuePair.getVal();
            }
        }
        return -1;
    }

    // void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
    public void remove(int key) {
        int h = hash(key);
        LinkedList<KeyValuePair> hList = data[h];
        for (KeyValuePair keyValuePair : hList) {
            if (keyValuePair.getKey() == key){
                hList.remove(keyValuePair);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
