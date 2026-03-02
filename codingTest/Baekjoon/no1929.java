package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
소수 구하기

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	334888	105394	74065	29.287%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1
3 16
예제 출력 1
3
5
7
11
13
*/
public class no1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[1000001];

        arr[1]=true;
        for (int i = 2; i * i <= N; i++) {
            // 1인 경우 예외케이스

            // 합성수 여부 확인
            if(arr[i]==true) continue;

            // 합성수인 경우 그의 배수항들은 모두 합성수(true) 처리
            if(arr[i] == false){
                int k = i * i;
                int gap = i;
                while(k<=N){
                    arr[k] = true;
                    k += gap;
                }
            }
        }

        for(int i = M; i<=N; i++){
            if(arr[i]== false)System.out.println(i);
        }
    }
}
