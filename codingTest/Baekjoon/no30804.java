package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
과일 탕후루 성공다국어

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	1024 MB	22086	8302	6743	36.331%
문제
은하는 긴 막대에
$N$개의 과일이 꽂혀있는 과일 탕후루를 만들었습니다. 과일의 각 종류에는
$1$부터
$9$까지의 번호가 붙어있고, 앞쪽부터 차례로
$S_1, S_2, \cdots, S_N$번 과일이 꽂혀있습니다. 과일 탕후루를 다 만든 은하가 주문을 다시 확인해보니 과일을 두 종류 이하로 사용해달라는 요청이 있었습니다.

탕후루를 다시 만들 시간이 없었던 은하는, 막대의 앞쪽과 뒤쪽에서 몇 개의 과일을 빼서 두 종류 이하의 과일만 남기기로 했습니다. 앞에서
$a$개, 뒤에서
$b$개의 과일을 빼면
$S_{a+1}, S_{a+2}, \cdots, S_{N-b-1}, S_{N-b}$번 과일, 총
$N-(a+b)$개가 꽂혀있는 탕후루가 됩니다.
$(0 \le a, b;$
$a+b < N)$ 

이렇게 만들 수 있는 과일을 두 종류 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많은 탕후루의 과일 개수를 구하세요.

입력
첫 줄에 과일의 개수
$N$이 주어집니다.
$(1 \le N \le 200\,000)$ 

둘째 줄에 탕후루에 꽂힌 과일을 의미하는
$N$개의 정수
$S_1, \cdots, S_N$이 공백으로 구분되어 주어집니다.
$(1 \le S_i \le 9)$ 

출력
문제의 방법대로 만들 수 있는 과일을 두 종류 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많은 탕후루의 과일 개수를 첫째 줄에 출력하세요.

예제 입력 1
5
5 1 1 2 1
예제 출력 1
4
과일을 앞에서
$1$개, 뒤에서
$0$개의 과일을 빼면 남은 과일은
$1, 1, 2, 1$번 과일이 꽂혀있는 탕후루가 됩니다. 과일의 개수는
$4$개입니다.

예제 입력 2
3
1 1 1
예제 출력 2
3
탕후루가 이미 두 종류 이하의 과일로만 이루어져 있습니다.

예제 입력 3
9
1 2 3 4 5 6 7 8 9
예제 출력 3
2
*/
public class no30804 {
    static boolean[][] visited;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int left = 0;
        int kind = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            if (count[input[right]] == 0) kind++;
            count[input[right]]++;

            while (kind > 2) {
                count[input[left]]--;
                if (count[input[left]] == 0) kind--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        arr  = new int[loop];
        visited = new boolean[loop][loop];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> set;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] eli = q.poll();
            set = new HashSet<>();
            int left = eli[0];
            int right = eli[1];
            if (left + right >= arr.length) continue;
            if(left >= arr.length || right >= arr.length){continue;}
            if(visited[left][right]){continue;}
            for(int i = left; i < arr.length - right; i++){
                set.add(arr[i]);
                if(set.size() > 2) break;
            }
            if(set.size() <= 2){
                return arr.length - right - left;
            }
            if (left + 1 <= arr.length && !visited[left + 1][right]) {
                visited[left + 1][right] = true;
                q.offer(new int[]{left + 1, right});
            }
            if (right + 1 <= arr.length && !visited[left][right + 1]) {
                visited[left][right + 1] = true;
                q.offer(new int[]{left, right + 1});
            }
        }
        return 2;
    }
}
