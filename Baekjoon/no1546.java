package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*
[문제설명][입력][출력][제한사항][예시]
- 모든 값 -> 해당 값/최대값 * 100 으로 변경
- 변경된 값들에 대한 평균
[입력]
- 첫째 줄 값의 갯수
- 둘째 줄 기존의 값 (0 <= n <= 100 / n중 최소한 하나는 0보다 큼)
[출력]
- 첫째 줄 평균 출력
[제한사항]
- 절대오차, 상대오차 소숫점 두번째 자리부터 허용
[예시]
예제 입력 1
3
40 80 60
예제 출력 1
75.0
예제 입력 2
3
10 20 30
예제 출력 2
66.666667
예제 입력 3
4
1 100 100 100
예제 출력 3
75.25
예제 입력 4
5
1 2 4 8 16
예제 출력 4
38.75*/
public class no1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            max = Math.max(max,values[i] = Integer.parseInt(st.nextToken()));
        }

        double sum = 0;
        for (double k: values) {
            sum += k/max * 100;
        }

        System.out.println(sum/count);
    }
}
