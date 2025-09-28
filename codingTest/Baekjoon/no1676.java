package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1
10
예제 출력 1
2
예제 입력 2
3
예제 출력 2
0
*/
public class no1676 {
    public static void another(String[] args) throws IOException {
        // 팩토리얼 계산 이후 값이 너무 커지는 상황 발생
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        BigInteger b = factorial(a);

        int result = 0;
        while(true){
            if(b.equals(BigInteger.ZERO)){System.out.println(0);}
            else if(b.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO)){
                result++;
                b = b.divide(BigInteger.valueOf(10));
            }
            else{
                break;
            }
        }
        System.out.print(result);
    }

    public static BigInteger factorial(int n) {
        if(n==0) return BigInteger.valueOf(1);
        if(n==1) return BigInteger.valueOf(1);
        return factorial(n-1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) throws IOException {
        // 0의 개수는 약수중 10의 개수를 세는것과 같다.
        // 팩토리얼 연산시 5의 배수존재시 앞의 2의 배수의 개수는 5보다 항상 많다
        // 5의 약수의 개수를 세는 것이 일의 자리부터 연속된 0의 개수를 세는것과 같다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if(a==0) System.out.println(0);
        else System.out.println(a/5 + a/25 + a/125);
    }
}
