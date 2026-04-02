package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
좌표 압축

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	136973	60268	44962	41.050%
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
예제 입력 1
5
2 4 -10 4 -9
예제 출력 1
2 3 0 3 1
예제 입력 2
6
1000 999 1000 999 1000 999
예제 출력 2
1 0 1 0 1 0
*/
public class no18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int loop = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] input = new int[loop][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < loop; i++) {
            input[i][0] = i;
            input[i][1] = Integer.parseInt(st.nextToken());
            int a = input[i][1];
            int cur_i = input[i][0];
            int j = i - 1;
            while (j >= 0 && input[j][1] > a) {
                input[j + 1][0] = input[j][0];
                input[j + 1][1] = input[j][1];
                j--;
            }
            input[j+1][0] = cur_i;
            input[j+1][1] = a;
        }


        int cnt = 0;
        int idx = 0;
        for (int i = 1; i < loop; i++) {
            while (i < loop && input[i - 1][1]  == input[i][1] ){
                i++;
            }

            for (int j = i - 1; j >= idx; j--) {
                input[j][1] = cnt;
            }
            idx = i;
            cnt++;
        }
        // 마지막구간처리
        for (int j = loop - 1; j >= idx; j--) {
            input[j][1] = cnt;
        }

        for(int i = 0; i < loop; i++){
            for(int j = 0; j < loop; j++){
                if(input[j][0] == i)sb.append(input[j][1] + " ");
            }
        }
        System.out.println(sb);
    }
}
