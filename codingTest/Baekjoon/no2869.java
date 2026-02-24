package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

예제 입력 1
2 1 5 3 1 8
예제 출력 1
4
예제 입력 2
5 1 6
예제 출력 2
2
예제 입력 3
100 99 1000000000
예제 출력 3
999999901*/
/*
* 룰
* 시작할때 하루가 시작한다.
* 수학적 방식 vs 부르스포트
* 1. 수학적 방식
* 2. 부르스포트 올라간 순간에 조건문 걸어서 확인 이후 날짜 증가 및 숫자감소
*
* 하루 일의 양으로 계산한뒤 마지막 올라간 양만큼 남았을 경우 탐색종료
* */
public class no2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        long goal = Long.parseLong(st.nextToken());

        int gap = up - down;
        long result = (long) (Math.ceil((double)(goal - up) / gap) + 1);
        System.out.println(result);
    }
}
