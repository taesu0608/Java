package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
* 문제
어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.

A+: 4.3, A0: 4.0, A-: 3.7

B+: 3.3, B0: 3.0, B-: 2.7

C+: 2.3, C0: 2.0, C-: 1.7

D+: 1.3, D0: 1.0, D-: 0.7

F: 0.0

입력
첫째 줄에 C언어 성적이 주어진다. 성적은 문제에서 설명한 13가지 중 하나이다.

출력
첫째 줄에 C언어 평점을 출력한다.

예제 입력 1
A0
예제 출력 1
4.0*/
public class no2754 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> hm = new HashMap<String, Double>();
        hm.put("A+", 4.3);
        hm.put("A0", 4.0);
        hm.put("A-", 3.7);

        hm.put("B+", 3.3);
        hm.put("B0", 3.0);
        hm.put("B-", 2.7);

        hm.put("C+", 2.3);
        hm.put("C0", 2.0);
        hm.put("C-", 1.7);

        hm.put("D+", 1.3);
        hm.put("D0", 1.0);
        hm.put("D-", 0.7);

        hm.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hm.get(br.readLine()));
    }
}
