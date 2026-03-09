package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
듣보잡
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	155766	69281	54481	42.702%
문제
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과,
N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.

예제 입력 1
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
예제 출력 1
2
baesangwook
ohhenrie
*/
public class no1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Set<String> set = new HashSet<String>();
        Set<String> result = new TreeSet<String>();
        //듣도 못한 사람
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        //보도 못한 사람
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(set.contains(str)){
                result.add(str);
            }
        }
        sb.append(result.size()).append("\n");
        for (String a : result) {
            sb.append(a).append("\n");
        }
        System.out.println("\n"+sb);
    }
}
