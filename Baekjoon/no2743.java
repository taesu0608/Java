package Baekjoon;

import java.io.*;

/*
* 단어 길이 재기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	110095	86861	77622	79.827%
문제
알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

출력
첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.

예제 입력 1
pulljima
예제 출력 1
8*/
public class no2743 {
    public static void main(String[] args) throws IOException {
        //write는 int형 char형으로 출력함 (아스키 코드로 출력됨)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(String.valueOf(input.length()));
        br.close();
        bw.flush();
        bw.close();
    }
}
