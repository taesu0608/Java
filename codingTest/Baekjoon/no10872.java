package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
*/

public class no10872 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i = 1; i <= n; i++){
            result += i;
        }
        System.out.println(result);
    }
}
