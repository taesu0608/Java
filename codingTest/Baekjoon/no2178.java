package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
미로 탐색

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	263864	126886	78634	46.310%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를
구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다.
항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1
4 6
101111
101010
101011
111011
예제 출력 1
15
예제 입력 2
4 6
110110
110110
111111
111101
예제 출력 2
9*/

public class no2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s2 = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s2.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = Integer.MAX_VALUE;
        q.offer(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if(cx == N - 1 && cy == M - 1){
                result = Math.min(result, cnt);
            }
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < arr.length && nx >= 0 && ny < arr[0].length && ny >= 0 && arr[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,cnt + 1});
                }
            }
        }
        return  result;
    }
}
