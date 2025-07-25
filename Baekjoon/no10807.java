package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
문제
총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며,
100보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.

예제 입력 1
11
1 4 1 2 4 2 4 2 3 4 4
2
예제 출력 1
3
예제 입력 2
11
1 4 1 2 4 2 4 2 3 4 4
5
예제 출력 2
0*/
public class no10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v =  Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(v == Integer.parseInt(st.nextToken()))
                cnt++;
        }
        bw.append(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
}
