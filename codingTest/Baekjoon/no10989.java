package codingTest.Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1
10
5
2
3
1
4
2
3
5
1
7
예제 출력 1
1
1
2
2
3
3
4
5
5
7
*/
public class no10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());

        int[] array = new int[10_001];
        for(int i = 0; i < loop; i++){
            int a = Integer.parseInt(br.readLine());
            array[a]++;
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                for(int j = array[i]; j > 0; j--){
                    sb.append(i).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < loop; i++){
            int a = Integer.parseInt(br.readLine());
            al.add(a);
        }

        al.sort((a, b) -> a - b);

        for (int num : al) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
