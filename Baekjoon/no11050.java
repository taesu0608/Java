package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제설명][입력][출력][제한사항][예시]
[문제설명]
정수 N과 정수 K를  이항계수
[예시]
예제 입력 1
5 2
예제 출력 1
10
 */
public class no11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Math.max(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
        int b = Math.min(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));

        System.out.println(factorial(a)/(factorial(a-b)*factorial(b)));
    }

    public static int factorial(int n){
        if(n==1||n==0) return 1;
        return n*factorial(n-1);
    }
}
