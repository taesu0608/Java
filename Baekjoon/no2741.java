package Baekjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/*자연수 N이 주어졌을 때,
1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.*/
public class no2741 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}
