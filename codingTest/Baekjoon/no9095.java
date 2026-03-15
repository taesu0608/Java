package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1, 2, 3 더하기 다국어

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (추가 시간 없음)	512 MB	155525	103550	72370	65.221%
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1
3
4
7
10
예제 출력 1
7
44
274
*/
public class no9095 {
    static class Data {
        int idx;
        int check;

        Data(int idx, int check) {
            this.idx = idx;
            this.check = check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        int input[] = new int[loop];

        for(int i = 0; i < loop; i++){
            input[i] = Integer.parseInt(br.readLine());
            int[] dp = new int[input[i]];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for(int n = 3; n < input[i]; n++){
                dp[n] = dp[n - 3]+ dp[n - 2] + dp[n - 1];
            }
            sb.append(dp[input[i] -1]).append("\n");
        }
        System.out.println(sb);
    }
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        int input[] = new int[loop];
        for(int i = 0; i < loop; i++){
            input[i] = Integer.parseInt(br.readLine());
            boolean[] b = new boolean[input[i] - 1];
            Queue<Data> q = new ArrayDeque<>();
            int cnt = 0;
            q.offer(new Data(0, 0));
            while(!q.isEmpty()) {
                Data data = q.poll();
                if(data.idx == input[i] - 1) {
                    cnt++;
                    continue;
                }
                if(data.check < 2) {
                    q.offer(new Data(data.idx + 1, data.check + 1));
                    q.offer(new Data(data.idx + 1, 0));
                } else {
                    q.offer(new Data(data.idx + 1, 0));
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
