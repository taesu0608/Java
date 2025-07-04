package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* [문제설명][입력][출력][제한사항][예시]
[문제설명]
알파벳 소문자로 구성된 N개의 단어 정렬
1. 길이 짧은 순
2. 동일 길이시 사전순
3. 중복 단어 제거

[입력][출력][제한사항][예시]
첫째 줄 단어의 개수 N(1 ≤ N ≤ 20,000)
둘째 줄 한줄에 하나의 단어. (문자열의 길이 < 50)

출력
조건에 따라 정렬하여 단어들을 출력한다.
* 예제 입력 1
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
예제 출력 1
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
* */
public class no1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        Set<String> set  = new HashSet();
        for (int i = 0; i < cnt; i++) {
            set.add(br.readLine());
        }
        List<String> al =  new ArrayList<>(set);

        al.sort((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });

        for (String word : al) {
            System.out.println(word);
        }
    }
}
