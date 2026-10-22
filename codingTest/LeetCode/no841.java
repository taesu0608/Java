package codingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class no841 {
    static boolean visited[];
    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        visited = new boolean[rooms.size()];

        visited[0] = true;
        dfs(0, rooms);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print(false);
            }
        }

        System.out.println(true);
    }

    public static void dfs(int idx, List<List<Integer>> rooms) {
        List<Integer> room = rooms.get(idx);

        for (int i : room) {
            if(visited[i]) continue;
            dfs(i, rooms);
        }
    }
}
