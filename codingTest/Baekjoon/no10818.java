package codingTest.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
* 최소, 최대
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	451125	206456	154926	44.532%
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

예제 입력 1
5
20 10 35 30 7
예제 출력 1
7 35
*/
public class no10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 1000000;
        int max = -1000001;
        int[] num = new int[roop];
        for (int i = 0; i < roop; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < roop; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }

        br.close();
        bw.write(min+" "+max);
        bw.close();
    }
}
