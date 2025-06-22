package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 1259. 팰린드롬수
-----------------

    [문제설명]
    랠림드롬
    - 뒤어서부터 읽어도 똑같은 단어

    [입력]
    1 <= N <= 99,999
    0 : 입력 종료

    [출력]
    'yes' or 'no'

    [제한사항]

[예시]
예제 입력 1
121
1231
12421
0
    예제 출력 1
    yes
    no
    yes
*/
public class no1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        char[] temp;
        while (true) {
            input = br.readLine();
            if (input.equals("0")) break;
            temp = input.toCharArray();
            for (int i = 0, j = input.length() - 1; i < input.length(); i++, j--) {
                temp[i] = input.charAt(j);
            }
            if (input.equals(new String(temp))) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String input;

        while (true) {
            sb = new StringBuilder(br.readLine());
            input = sb.toString();
            sb.reverse();

            if (input.equals("0")) break;

            if (input.equals(sb.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("input" + input);
                System.out.println("sb" + sb.toString());
                System.out.println("no");
            }
        }
    }
}
