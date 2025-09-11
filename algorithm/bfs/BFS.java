package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/*
문제

정수선에서 시작점 N에서 목표 M으로 가자.
한 번에 +1 또는 -1로만 움직일 수 있다. 최소 이동 횟수 출력.

풀이 핵심

상태(노드): 현재 값 x

이웃: x-1, x+1

dist[x] == 처음 도달한 횟수(최단)
*/
public class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");

        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);

        int MAX = 100000; //최대 범위
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0; //시작은 0번 이동

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x==M){
                System.out.println(dist[x]);
                return;
            }

            if( x - 1 >= 0 && dist[x - 1] != -1){
                dist[x - 1] = dist[x] + 1;
                q.offer(x - 1);
            }

            if( x + 1 <= MAX && dist[x + 1] != -1){
                dist[x + 1] = dist[x] + 1;
                q.offer(x + 1);
            }
        }
    }
}
