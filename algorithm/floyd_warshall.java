package algorithm;

import java.util.Arrays;

public class floyd_warshall {
    public static void main(String[] args) {
        int n = 5;
        long[][] dist = new long[n][n];
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if(i==j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        for (long[] d : dist) {
            System.out.println(Arrays.toString(d));
        }
    }
}
