package algorithm;

import java.util.*;

public class Bellman_Ford {
    public static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int[] dist;
    public static void main(String[] args) {
        String[] nodes = {"A", "B", "C", "D", "E"};
        dist = new int[nodes.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;        // 정점 번호: A=0, B=1, C=2, D=3, E=4
        // 각 간선: {출발 정점, 도착 정점, 가중치}
        int[][] edges = {
                {0, 1, 6},
                {0, 2, 7},
                {1, 2, 8},
                {1, 3, 5},
                {1, 4, -4},
                {2, 3, -3},
                {2, 4, 9},
                {3, 1, -2},
                {4, 0, 2},
                {4, 3, 7}
        };
        ArrayList<Edge> edgesList = new ArrayList<>();

        for(int[] e: edges){
            edgesList.add(new Edge(e[0], e[1], e[2]));
        }
        bellman(edgesList, nodes.length);

        System.out.println(Arrays.toString(dist));
    }
    public static void bellman(ArrayList<Edge> edges, int n){
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < edges.size(); j++){
                Edge edge = edges.get(j);
                if(dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight){
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        // 음수 사이클 검사
        for (int i = 0; i < edges.size(); i++){
            Edge edge = edges.get(i);
            if(dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight){
                System.out.println("음의 사이클 발생" + " to: "+edge.to + " from: "+ edge.from + " weight: "+ edge.weight);
            }
        }
    }
}
