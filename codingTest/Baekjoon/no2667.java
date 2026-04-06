package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1
3
7
8
9
*/
public class no2667 {
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        arr = new int[loop][loop];
        visited = new boolean[loop][loop];
        for (int i = 0; i < loop; i++) {
            String s = br.readLine();
            for (int j = 0; j < loop; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < loop; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int num : list) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }
    public static int bfs(int i, int j) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        int result = 1;

        while (!q.isEmpty()){
            int a[] = q.poll();
            int cx = a[0];
            int cy = a[1];
            int nx;
            int ny;

            for (int k = 0; k < 4; k++) {
                nx = cx + dx[k];
                ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length ) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                result++;
                }
            }

        return result;
    }
}
