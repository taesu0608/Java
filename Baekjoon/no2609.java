package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제설명][입력][출력][제한사항][예시]
[문제설명]
- 두개의 자연수의 최대공약수, 최소공배수 출력

[입력]
첫째 줄 두 개의 자연수(0 <= a,b <= 10,000)

[출력]
첫째 줄 최대공약수
둘째 줄 최소 공배수 출력

[제한사항]
-

[예시]

예제 입력 1
24 18
예제 출력 1
6
72
 */
public class no2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int gcd = 1;
        for(int i = 1; i <= b; i++){
            if (a%i == 0 && b%i == 0){
                gcd = i;
            }
        }

        int lcm_a = a;
        int lcm_b = b;

        while(lcm_a != lcm_b){
            if(lcm_a > lcm_b){
                lcm_b += b;
            } else {
                lcm_a += a;
            }
        }

        System.out.println(gcd + "\n"+ lcm_b);
    }

    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int a = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        int b = Math.min(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

        System.out.println(gcd(a,b)+"\n"+lcm(a,b));


    }

    public static int gcd(int a, int b) {
          if (b==0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        if (b==0) return a;
        return (a*b)/gcd(a , b);
    }
}
