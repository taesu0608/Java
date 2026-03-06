package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
FizzBuzz 스페셜 저지다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초	1024 MB	22210	13503	12220	60.902%
문제
FizzBuzz 문제는
$i = 1, 2, \cdots$ 에 대해 다음 규칙에 따라 문자열을 한 줄에 하나씩 출력하는 문제입니다.

입력
FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 한 줄에 하나씩 주어집니다. 각 문자열의 길이는
$8$ 이하입니다. 입력이 항상 FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열에 대응됨이 보장됩니다.

출력
연속으로 출력된 세 개의 문자열 다음에 올 문자열을 출력하세요. 여러 문자열이 올 수 있는 경우, 아무거나 하나 출력하세요.

예제 입력 1
Fizz
Buzz
11
예제 출력 1
Fizz
예제 입력 2
980803
980804
FizzBuzz
예제 출력 2
980806
*/
public class no28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        for (int i = 3 ; i > 0; i--){
            String s = br.readLine();
            //Character.isDigit(s.charAt(0))
            if (s.charAt(0) >= '1' && s.charAt(0) <= '9'){
                input = Integer.parseInt(s) + i;

                if(input % 3 == 0 && input % 5 == 0){
                    System.out.println("FizzBuzz");
                } else if(input % 3 == 0){
                    System.out.println("Fizz");
                } else if(input % 5 == 0){
                    System.out.println("Buzz");
                } else {
                    System.out.println(input);
                }

                return;
            }
        }
    }
}
