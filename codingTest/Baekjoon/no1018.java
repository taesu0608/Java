package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

예제 입력 1
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW

예제 출력 1
1
예제 입력 2
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
예제 출력 2
12
*/
public class no1018 {
    // 1. t/f의 반복을 자료형이 아닌 반복문으로 해결하기
    // 2. 여러 곳에서 참조되는 배열은 static으로 선언하기
    public static boolean[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        // black = true, white = false
        input = new boolean[rows][cols];

        /*
        * [as is]
        * br.readline 이후 StringTokenizer로 "" 단위로 끊어 String[] 으로 처리
        *
        * [to be]
        * br.readline을 String으로 저장 이후 charAt()으로 처리
        *
        * 한글자씩 처리는 ""로 Token화가 아닌 charAt()으로 처리
        * */
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                // as is 삼항연산자, to be 삼항연산자 삭제
                input[i][j] = line.charAt(j) == 'B';
            }
        }

        int result = Integer.MAX_VALUE;
        int rows_S = rows - 7;
        int cols_S = cols - 7;
        for (int i = 0; i < rows_S; i++) {
            for (int j = 0; j < cols_S; j++) {
                result = Math.min(result,check(i, j));
            }
        }

        System.out.println(result);

    }
    static int check(int n, int m){
        int count = 0;
        boolean TF = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (input[i+n][j+m]==TF) {
                    count++;
                }
                TF = !TF;
            }
            TF = !TF;
        }
        return Math.min(count,64-count);
    }
}
