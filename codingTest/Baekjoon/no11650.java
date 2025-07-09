package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1
5
3 4
1 1
1 -1
2 2
3 3
예제 출력 1
1 -1
1 1
2 2
3 3
3 4
*/

public class no11650 {
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] split;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < count ; i++){
        split = br.readLine().split(" ");

        map.computeIfAbsent(Integer.parseInt(split[0]), k -> new ArrayList<>()).add(Integer.parseInt(split[1]));
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())  // 키 기준 오름차순 정렬
                .forEach(entry -> {
                    int x = entry.getKey();
                    List<Integer> yList = entry.getValue();
                    // y 오름차순 정렬
                    Collections.sort(yList);
                    for (int y : yList) {
                        System.out.println(x + " " + y);
                    }
                });
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        String[] split;
        int[][] input = new int[count][2];

        for (int i = 0; i < count; i++) {
            split = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(split[0]);
            input[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(input, (x,y) -> {
            return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
        });

        for (int i = 0; i < input.length; i++) {
            sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}
