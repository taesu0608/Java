package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
헌내기는 친구가 필요해 성공

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (하단 참고)	1024 MB	23337	14219	11801	60.440%
문제
2020년에 입학한 헌내기 도연이가 있다. 도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다. 드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다.

도연이가 다니는 대학의 캠퍼스는
$N \times M$ 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다. 예를 들어, 도연이가 (
$x$,
$y$)에 있다면 이동할 수 있는 곳은 (
$x+1$,
$y$), (
$x$,
$y+1$), (
$x-1$,
$y$), (
$x$,
$y-1$)이다. 단, 캠퍼스의 밖으로 이동할 수는 없다.

불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.

입력
첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수
$N$ (
$ 1 \leq N \leq 600$),
$M$ (
$ 1 \leq M \leq 600$)이 주어진다.

둘째 줄부터
$N$개의 줄에는 캠퍼스의 정보들이 주어진다. O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.

출력
첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.

예제 입력 1
3 5
OOOPO
OIOOX
OOOXP
예제 출력 1
1
예제 입력 2
3 3
IOX
OXP
XPP
예제 출력 2
TT
*/
public class no21736 {
    static char[][] arr;
    static boolean[][] visited;
    static int person = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);

        int[] cur = new int[2];
        arr = new char[x][y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String[] s2 = br.readLine().split("");
            for (int j = 0; j < y; j++) {
                arr[i][j] = s2[j].charAt(0);
                if(arr[i][j] == 'I') {cur[0] = i; cur[1] = j;}
            }
        }

        bfs(cur[0], cur[1]);

        if(person == 0 ) System.out.println("TT");
        else System.out.println(person);
    }

    public static void bfs(int cur_x, int cur_y){
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{cur_x,cur_y});
        while(!q.isEmpty()){
            int[] point = q.poll();
            if (point[0] >= arr.length || point[1] >= arr[0].length || point[0] < 0 || point[1] < 0) {
                continue;
            }

            if(visited[point[0]][point[1]]){ continue;}
            visited[point[0]][point[1]] = true;

            if(arr[point[0]][point[1]] == 'X') continue;
            switch (arr[point[0]][point[1]]) {
                case 'O':
                    break;
                case 'P':
                    person++;
                    break;
            }

            q.offer(new int[]{point[0]-1,point[1]});
            q.offer(new int[]{point[0]+1,point[1]});
            q.offer(new int[]{point[0],point[1]-1});
            q.offer(new int[]{point[0],point[1]+1});
        }
    }
}
