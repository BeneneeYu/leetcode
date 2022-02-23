package bfs.graph.question841;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-02-23 09:32
 **/
public class Solution {
    boolean[] visit;
    int num;

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        int len = rooms.size();
        visit = new boolean[len];
        num = 0;
        dfs(rooms, 0);
        return num == len;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        visit[x] = true;
        num++;
        for (Integer integer : rooms.get(x)) {
            if (!visit[integer]) {
                dfs(rooms, integer);
            }
        }
    }

    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        int len = rooms.size();
        visit = new boolean[len];
        num = 0;
        Queue<Integer> queue = new LinkedList<>();
        visit[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            num++;
            for (Integer integer : rooms.get(tmp)) {
                if (!visit[integer]) {
                    visit[integer] = true;
                    queue.offer(integer);
                }
            }
        }
        return num == len;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> unVisitedRoomSet = new HashSet<>();
        fulfill(unVisitedRoomSet, rooms.size());
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        unVisitedRoomSet.remove(0);
        while (!(queue.isEmpty())) {
            int tmpRoom = queue.remove();
            for (Integer integer : rooms.get(tmpRoom)) {
                if (unVisitedRoomSet.contains(integer)) {
                    queue.add(integer);
                    unVisitedRoomSet.remove(integer);
                }
            }
        }
        return unVisitedRoomSet.isEmpty();
    }

    private void fulfill(Set<Integer> set, int length) {
        set.clear();
        for (int i = 0; i < length; i++) {
            set.add(i);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> room0 = new ArrayList<>();
        room0.add(1);
        ArrayList<Integer> room1 = new ArrayList<>();
        ArrayList<Integer> room2 = new ArrayList<>();
        room2.add(0);
        room2.add(3);
        ArrayList<Integer> room3 = new ArrayList<>();
        room3.add(1);
        list.add(room0);
        list.add(room1);
        list.add(room2);
        list.add(room3);
        System.out.println(s.canVisitAllRooms(list));
    }
}
