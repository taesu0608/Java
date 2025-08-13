package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력 1
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
예제 출력 1
2
2
0
2
1
-1
0
1
-1
0
3
*/
public class no10828 {
    static LinkedList<Integer> stack = new LinkedList();
    static int[] array = new int[100_000];
    static int c_idx = 0;

    public static void main(String[] args) throws IOException {
        // LinkedList 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int roop = Integer.parseInt(br.readLine());

        for(int i = 0; i < roop; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": System.out.println(pop()); break;
                case "size": System.out.println(size()); break;
                case "empty": System.out.println(empty()?1:0); break;
                case "top": System.out.println(top()); break;
            }
        }
    }

    static public void push2(int input) {
        stack.push(input);
    }
    static public int pop2() {
        if (stack.isEmpty()) return -1;
        return stack.pop();
    }
    static public int size2() {
        return stack.size();
    }
    static public boolean empty2() {
        return stack.isEmpty();
    }
    static public int top2() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    static public void push(int input) {
        array[c_idx++] = input;
    }
    static public int pop() {
        if (empty()) return -1;
        return array[--c_idx];
    }
    static public int size() {
        return c_idx;
    }
    static public boolean empty() {
        return c_idx == 0;
    }
    static public int top() {
        if (empty()) return -1;
        return array[c_idx-1];
    }
}