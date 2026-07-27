package codingTest.LeetCode;

import java.util.*;

public class no743 {
    class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]].add(new Edge(times[i][1], times[i][2]));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, distance[k]});
        while(!pq.isEmpty()) {
            int[] input = pq.poll();
            int node = input[0];
            int currentDistance = input[1];
            visited[node] = true;
            List<Edge> le = graph[node];

            for (Edge e : le) {
                if (visited[e.to]) {continue;}
                int newDistance = currentDistance + e.weight;

                if (newDistance < distance[e.to]) {
                    distance[e.to] = newDistance;
                    pq.add(new int[]{e.to, newDistance});
                }
            }
        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, distance[i]);
        }

        return answer;
    }
}
