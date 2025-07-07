package codingTest.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
소수 찾기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	251298	119873	95825	47.414%
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1
4
1 3 5 7
예제 출력 1
3
*/
public class no1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i++){
            if(isPrime(Integer.parseInt(st.nextToken())))
            {result++;}
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i = 3; i * i <= n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }
}
