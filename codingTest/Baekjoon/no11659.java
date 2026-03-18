package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
구간 합 구하기 4
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	179370	74383	53625	38.661%
문제
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N
예제 입력 1
5 3
5 4 3 2 1
1 3
2 4
5 5

5 1
5 4 3 2 1
1 3

예제 출력 1
12
9
1
*/
public class no11659 {
    static int[] dp;
    static int size;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        size = Integer.parseInt(st.nextToken());
        dp = new int[size];
        arr = new int[size];
        int loop = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            dp[i] = sum;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(calcul(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    public static int calcul(int a, int b){
        if (a==0) return dp[b];
        return dp[b] - dp[a - 1];
    }
}
