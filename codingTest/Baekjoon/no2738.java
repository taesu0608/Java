package codingTest.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
문제
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

입력
첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고,
행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력
첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.

예제 입력 1
3 3
1 1 1
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100
예제 출력 1
4 4 4
6 6 6
5 6 100*/
public class no2738 {
    // 중간과정을 생략하고자 결정을 하였을때는 더욱 압축가능한 과정이 있나 생각 할 것
    // B 배열을 사용하지 않고 A 배열에 합을 통해서 연산하기로 정하였다면
    // 합과 동시에 출력의 형태를 조정하는 방식으로 반복문 1회를 덜 돌릴수 있었다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                A[i][j] += Integer.parseInt(st.nextToken());
                bw.write(A[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
