package Baekjoon;

import java.io.*;

/*
* 문제
영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

출력
첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.

예제 입력 1
WrongAnswer
예제 출력 1
wRONGaNSWER*/
public class no2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if ( 'a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                bw.append((char)((int)input.charAt(i) - 32));
            } else if ( 'A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                bw.append((char)((int)input.charAt(i) + 32));
            }
        }

        br.close();
        bw.flush();
        br.close();
    }
}
