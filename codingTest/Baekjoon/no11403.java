package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
경로 찾기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	62900	40390	30159	64.020%
문제
가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가
양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이
주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는
없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 길이가 양수인
경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

예제 입력 1
3
0 1 0
0 0 1
1 0 0
예제 출력 1
1 1 1
1 1 1
1 1 1
예제 입력 2
7
0 0 0 1 0 0 0
0 0 0 0 0 0 1
0 0 0 0 0 0 0
0 0 0 0 1 1 0
1 0 0 0 0 0 0
0 0 0 0 0 0 1
0 0 1 0 0 0 0
예제 출력 2
1 0 1 1 1 1 1
0 0 1 0 0 0 1
0 0 0 0 0 0 0
1 0 1 1 1 1 1
1 0 1 1 1 1 1
0 0 1 0 0 0 1
0 0 1 0 0 0 0
*/
public class no11403 {
    static class Node {
        int value = 0;
        ArrayList<Node> adjacent;

        public Node(int value){
            this.value = value;
            adjacent = new ArrayList<>();
        }

        public void add(Node n){
            adjacent.add(n);
        }
        public ArrayList<Node> getAdjacent(){
            return adjacent;
        }
    }
    public static void search(Node start, Node current) {
        for (Node n : current.getAdjacent()) {
            if (!visited[n.value]) {
                visited[n.value] = true;
                result[start.value][n.value] = 1;
                search(start, n);
            }
        }
    }
    static int[][] arr;
    static int[][] result;
    static boolean[] visited;
    static HashMap<Integer, Node> nodes;
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int loop = Integer.parseInt(br.readLine());
        arr = new int[loop][loop];
        result = new int[loop][loop];
        nodes = new HashMap();
        visited = new boolean[loop];
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < loop; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    nodes.putIfAbsent(i, new Node(i));
                    nodes.putIfAbsent(j, new Node(j));
                    Node in = nodes.get(i);
                    Node jn = nodes.get(j);
                    in.adjacent.add(jn);
                }
            }
        }

        /*for (Node n : nodes.values()) {
            search(n);
        }*/

        for (int i = 0; i < loop; i++) {
            Arrays.fill(visited, false);
            Node start = nodes.get(i);
            if (start != null) {
                search(start, start);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < loop; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        int loop = Integer.parseInt(br.readLine());
        arr = new int[loop][loop];
        result = new int[loop][loop];
        visited = new boolean[loop];

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < loop; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < loop; i++) {
            visited = new boolean[loop];
            dfs(i, i);
        }

        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < loop; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int current) {
        for (int next = 0; next < arr.length; next++) {
            // 인접하면서 방문하지 않은 경우
            if (arr[current][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start,next);
            }
        }
    }
}
