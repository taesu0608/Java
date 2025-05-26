package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
Scanner, System.out.println 대신
BufferedReader (입력)
BufferedWriter (출력) 사용
BufferedWriter.flush()는 마지막에 한 번만 호출

첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

예제 입력 1
5
1 1
12 34
5 500
40 60
1000 1000

예제 출력 1
2
46
505
100
2000
*/

public class no15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String test = "3 1 2 4 5 6 7 ";
        //BufferedReader br = new BufferedReader(new StringReader(test));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int executionNo = Integer.parseInt(br.readLine());

        for (int i = 0; i < executionNo; i++) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                bw.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())+"\n");
            }catch (Exception e) {}
        }
        bw.flush();
    }
}
