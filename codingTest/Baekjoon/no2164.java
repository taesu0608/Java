 package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

 /*
 문제
 N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다.
 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

 N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.

 출력
 첫째 줄에 남게 되는 카드의 번호를 출력한다.

 예제 입력 1
 6
 예제 출력 1
 4
 */
public class no2164 {
    public static void another(String[] args) throws IOException {
        //Java에서 String 및 StringBuilder를 반복적으로 생성하거나 복사하는 방식은 성능과 메모리 측면에서 비효율적
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= input; i++) {
            sb.append(i);
        }

        for (int i = 0; i < 2*input-3; i++) {
            if(flag==true){
                sb = new StringBuilder(sb.substring(1,sb.length()));
            }else{
                char x = sb.charAt(0);
                sb = new StringBuilder(sb.substring(1,sb.length()));
                sb.append(x);
            }
            flag = !flag;
        }

        System.out.print(sb);
    }
    public static void another2(String[] args) throws IOException {
        // 문자열을 활용하는 아이디어는 그대로 가져가되 index를 활용하는 방식으로 변경
        // index 관리가 필요함 -> 사실 이게 큐랑 다를바가 없네
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        //연산 표시를 위한 신호
        boolean flag = true;
        //숫자가 뒤로 배치될 경우 배열이 가져야될 최소사이즈
        int[] result = new int[2*input - 1];

        for (int i = 1; i <= input; i++) {
            result[i-1] = i;
        }

        int start_idx = 0;
        int end_idx = input-1;
        for (int i = 0; i < 2*input-3; i++) {
            if(flag==true){
                start_idx++;
            }else{
                result[end_idx + 1]  = result[start_idx];
                end_idx++;
                start_idx++;
            }
            flag = !flag;
        }
            System.out.println(result[end_idx]);
    }
    public static void another3(String[] args) throws IOException {
        // 큐로 구현
        // q.size() 라는 메서드 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < input; i++) {
            q.offer(i+1);
        }


        while(q.size() > 1){
                q.poll();
                q.offer(q.poll());
        }

        System.out.println(q.peek());
    }
    public static void another4(String[] args) throws IOException{
        // 원형 큐로 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < input; i++) {
            q.offer(i+1);
        }

        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.peek());
    }

    public static void main(String[] args) throws IOException {
        // 수식 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int n = 1;
        while(n <= input){

        }
    }
}
