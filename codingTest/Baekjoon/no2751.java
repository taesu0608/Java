package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1
5
5
4
3
-2
1
예제 출력 1
1
2
3
4
5*/
public class no2751 {
    /*
    1.boolean 배열 초기화시 false 보다 int 0으로 초기화 되는것이 리소스가 더 적게 든다.
    * false는 바이트 단위 초기화이기 때문에 비트 단위 초기화인 int형 배열이 더 빠름
    *
    *
    2. 많은 출력시 StringBuilder 적극 사용
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[2000002];

        for (int i = 0; i < count; i++) {
            visited[Integer.parseInt(br.readLine())+1000001] = true;
        }
        for (int i = 0; i < 2000002; i++) {
            if (visited[i]) {
                System.out.println(i-1000001);
            }
        }
    }

    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[2000001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if  (arr[i] > 0) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.println(sb);
    }
}
