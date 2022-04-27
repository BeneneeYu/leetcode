package daily.question1202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-04-27 08:51
 **/
public class Solution {
    // Maximum number of vertices, 1 <= s.length <= 10^5
    final static int N = 100001;
    boolean[] visited = new boolean[N];
    List<Integer>[] adjacentVertex = new ArrayList[N];

    // s = "dcab", pairs = [[0,3],[1,2]]
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        for (int i = 0; i < adjacentVertex.length; i++) {
            adjacentVertex[i] = new ArrayList<>();
        }
        // Build the adjacency list
        for (List<Integer> edge : pairs) {
            int start = edge.get(0);
            int end = edge.get(1);
            adjacentVertex[start].add(end);
            adjacentVertex[end].add(start);
        }
        char[] answer = new char[s.length()];
        for (int vertex = 0; vertex < s.length(); vertex++) {
            // If not covered in the DFS yet
            if (!visited[vertex]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indexes = new ArrayList<>();

                // After the DFS is over, all the vertex in a connected component have been traversed
                dfs(s, vertex, characters, indexes);
                Collections.sort(characters);
                Collections.sort(indexes);

                // Store the sorted characters corresponding to the index
                for (int i = 0; i < characters.size(); i++) {
                    answer[indexes.get(i)] = characters.get(i);
                }
            }
        }
        return new String(answer);
    }

    private void dfs(String s, int vertexIndex, List<Character> characters, List<Integer> indexes) {
        List<Integer> adjacentList = adjacentVertex[vertexIndex];
        // in a process of traversing all adjacent vertex
        visited[vertexIndex] = true;
        // Add the character and index to the list (for the future sort of characters in a connected component)
        characters.add(s.charAt(vertexIndex));
        indexes.add(vertexIndex);
        // Traverse the adjacents
        for (Integer integer : adjacentList) {
            if (!visited[integer]) {
                dfs(s, integer, characters, indexes);
            }
        }
    }

}
