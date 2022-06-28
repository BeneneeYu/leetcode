package dataStructure.unionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-28 14:59
 **/
public class UnionFind{
    private Map<Integer, Integer> father; // store the father node of every node
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