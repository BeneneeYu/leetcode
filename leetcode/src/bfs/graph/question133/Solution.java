package bfs.graph.question133;

import bfs.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 08:02
 **/
public class Solution {
    // array is also OK
    private HashMap<Node, Node> deepCopyNodes = new HashMap<>();

    public Node cloneGraphDFS(Node node) {
        if (null == node) {
            return null;
        }
        if (deepCopyNodes.containsKey(node)) {
            return deepCopyNodes.get(node);
        } else {
            Node deepCopyNode = new Node(node.val, new ArrayList<>());
            deepCopyNodes.put(node, deepCopyNode);
            for (Node neighbor : node.neighbors) {
                deepCopyNode.neighbors.add(cloneGraphDFS(neighbor));
            }
            return deepCopyNode;
        }
    }

    public Node cloneGraphBFS(Node node) {
        if (null == node) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        deepCopyNodes.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node tmp = queue.remove();
            for (Node neighbor : tmp.neighbors) {
                if (!deepCopyNodes.containsKey(neighbor)) {
                    Node deepCopyNode = new Node(neighbor.val, new ArrayList<>());
                    deepCopyNodes.put(neighbor, deepCopyNode);
                    queue.add(neighbor);
                }
                deepCopyNodes.get(tmp).neighbors.add(deepCopyNodes.get(neighbor));
            }
        }
        return deepCopyNodes.get(node);
    }
}
