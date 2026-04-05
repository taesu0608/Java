package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는
가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1
5 17
예제 출력 1
4
*/
public class no1697 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(bfs(n,k));
    }
    public static int bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {n,0});
        int result = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            //완료조건
            if(cur[0] == k)result = Math.min(cur[1], result);

            if(cur[0]+1 < visited.length && !visited[cur[0] + 1]){
                visited[cur[0] + 1] = true;
                q.offer(new int[]{cur[0] + 1,cur[1] + 1});
            }
            if(cur[0] - 1 >= 0 && !visited[cur[0] - 1]){
                visited[cur[0] - 1] = true;
                q.offer(new int[] {cur[0] - 1,cur[1] + 1});
            }
            if(cur[0]*2 < visited.length && !visited[cur[0]*2]){
                visited[cur[0]*2] = true;
                q.offer(new int[] {2*cur[0],cur[1] + 1});
            }
        }

        return result;
    }
}
