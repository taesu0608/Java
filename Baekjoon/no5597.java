package Baekjoon;

import java.io.*;

/*
문제
X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.

교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.

입력
입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.

출력
출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.

예제 입력 1
3
1
4
5
7
9
6
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
예제 출력 1
2
8
예제 입력 2
9
30
6
12
10
20
21
11
7
5
28
4
18
29
17
19
27
13
16
26
14
23
22
15
3
1
24
25
예제 출력 2
2
8*/
public class no5597 {
    // 저장 및 배열의 경우 저장과 배열이 동시에 이뤄지는 것이 아닌 저장과 배열이 따로 이뤄지는 것이 좋다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[31];

        for (int i = 1; i < 29; i++) {
            a[Integer.parseInt(br.readLine())] = 1;
        }

        for (int i = 1; i < 31; i++) {
            if (a[i] == 0) {
                bw.write(i + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
