package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

/*
문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

예제 입력 1
7 3
예제 출력 1
<3, 6, 2, 7, 5, 1, 4>
*/
public class no11866 {
    public static void another(String[] args) throws IOException {
        // 단순 반복 + flag
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");

        int loop = Integer.parseInt(temp[0]);
        int step = Integer.parseInt(temp[1]);
        int index = 0;
        boolean[] array = new boolean[loop];

        sb.append("<");

        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < step; j++) {
                if (array[index]) {
                    j--;
                } else {
                    if(j == step - 1){
                        array[index] = true;
                        sb.append(index + 1);
                        if (i < loop-1) { sb.append(", ");}
                    }
                }
                index++;
                index %= loop;
            }
        }

        sb.append(">");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
    // 원형 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");

        int roop = Integer.parseInt(input[0]);
        int step = Integer.parseInt(input[1]);

        C_Queue cq = new C_Queue(roop + 1);
        sb.append("<");
        for (int i = 0; i < roop; i++) {
            cq.push(i + 1);
        }

        while (!cq.isEmpty()) {
            for (int i = 0; i < step - 1; i++) {
                int x = cq.pop();
                cq.push(x);
            }
            sb.append(cq.pop());
            if(!cq.isEmpty()) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }

    public static class C_Queue {
        int[] array;
        int capacity = 0;
        int front = 0;
        int rear = 0;
        public C_Queue(int capacity){
            this.capacity = capacity;
            array = new int[capacity];
        }

        public int push(int i){
            if(!isFull()){
                int result = array[rear] = i;
                rear = (rear + 1) % capacity;
                return result;
            }
            return 0;
        }
        public int pop(){
            if(!isEmpty()) {
                int result = array[front];
                front = (front + 1) % capacity;
                return result;
            }
            return 0;
        }
        public boolean isEmpty(){
            if(front==rear) return true;
            else return false;
        }

        public boolean isFull(){
            if(front==(rear + 1)%capacity) return true;
            return false;
        }
    }
}
