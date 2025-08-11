package codingTest.Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
숫자 카드 2
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	187892	76404	54359	38.868%
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때,
이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며,
이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

예제 입력 1
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
예제 출력 1
3 0 0 1 2 0 0 2
*/
public class no10816 {
    public static void another(String[] args) throws IOException {
        // Map으로 k,v <수, 수의 갯수>
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<Integer,Integer> map = new HashMap<>();

        //상근이가 가지고 있는 카드
        int input1 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input1; i++) {
            int key = Integer.parseInt(st.nextToken());
            // 미존재하는 key 는 1로 설정, key 존재시 value +1;
            map.merge(key, 1, Integer::sum);
        }

        //확인해야할 카드
        int input2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input2; i++) {
            int findKey = Integer.parseInt(st.nextToken());
            bw.append(map.getOrDefault(findKey, 0)+" ");
        }

        bw.flush();
        bw.close();
    }

    // Array 배열 사용
    static final int DefaultValue = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] input = new int[DefaultValue * 2];

        int roop = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 값 저장 index = 수, 요소 = 수의 빈도
        for (int i = 0; i < roop; i++) {
            int index = Integer.parseInt(st.nextToken());
            input[DefaultValue + index] += 1;
        }

        // 값 탐색
        int roop2= Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < roop2; i++) {
            int index = Integer.parseInt(st.nextToken());
            sb.append(input[DefaultValue + index]+" ");
        }

        System.out.println(sb);
    }
}
