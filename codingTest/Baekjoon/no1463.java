package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/*
제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1
2
예제 출력 1
1
예제 입력 2
10
예제 출력 2
3
*/
public class no1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int MAX = 1000_001;
        int[] dist = new int[MAX];
        Arrays.fill(dist,-1);
        q.offer(n);

        int result = 1000_001;

        dist[n] = 0;
        // q가 비워질 때 까지
        while (!q.isEmpty()) {
            // q 꺼내기, x는 현재 정수 값
            int cur = q.poll();
            // 브레이크 포인트) 현재 정수값이 1이 되었을 때
            // 기존값과 비교하여 최솟값 저장
            if (cur == 1){ result = Math.min(result,dist[cur]); break;}
            // 현재 값이 1이상, 미탐색 지역일때
            if(cur > 1){
                // 현재 값이 3으로 나눠질 때
                if(cur%3 == 0){
                    //현재의 경우가 쓰레기일 경우 탐색 중지
                    if(dist[cur/3] != -1){
                        // 현재의 값이 더 좋을 경우 삽입
                        if(dist[cur/3] > dist[cur] + 1){
                            dist[cur/3] = 1 + dist[cur];
                            q.offer(cur/3);
                        }
                    }
                    else{
                        dist[cur/3] = dist[cur] + 1;
                        q.offer(cur/3);
                    }
                }
                // 현재 값이 2로 나눠질 때
                if(cur%2 == 0){
                    if(dist[cur/2] != -1){
                        if(dist[cur/2] > dist[cur] + 1){
                            dist[cur/2] = 1 + dist[cur];
                            q.offer(cur/2);
                        }
                    }
                    else{
                        dist[cur/2] = 1 + dist[cur];
                        q.offer(cur/2);
                    }
                }
                // 모든 경우
                if(dist[cur - 1] != -1){
                    if(dist[cur - 1] > dist[cur] + 1){
                        dist[cur - 1] = 1 + dist[cur];
                        q.offer(cur - 1);
                    }
                }
                else{
                    dist[cur - 1] = 1 + dist[cur];
                    q.offer(cur - 1);
                }
            }
        }

        System.out.println(result);
    }
}
