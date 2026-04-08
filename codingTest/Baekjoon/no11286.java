package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/*
절댓값 힙
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (추가 시간 없음) (하단 참고)	256 MB	81663	47523	37187	57.997%
문제
절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

배열에 정수 x (x ≠ 0)를 넣는다.
배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
입력되는 정수는 -231보다 크고, 231보다 작다.

출력
입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

예제 입력 1
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
예제 출력 1
-1
1
0
-1
-1
1
1
-2
2
0
*/

public class no11286 {
    static int[] arr;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        arr = new int[loop + 1];

        int idx = 0;
        for (int i = 0; i < loop; i++) {
            String s = br.readLine();
            if(s.charAt(0) == '0') sb.append(remove()).append("\n");
            else {
                add(Integer.parseInt(s));
            }
        }

        System.out.println(sb);
    }
    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                return Integer.compare(b, a);
            }
            return Integer.compare(absB, absA);
        }
    };
    public static void add(Integer value){
        int index = ++size;

        while(index > 1){
            int parent = index / 2;

            if(comp.compare(value, arr[parent]) <= 0){ break; }

            arr[index] = arr[parent];
            index = parent;
        }

        arr[index] = value;
    }
    public static int remove() {
        if(size == 0) return 0;
        int root = arr[1];
        int last = arr[size];
        arr[size] = 0;
        size--;

        int index = 1;
        while(true) {
            int left = index*2;
            int right = index*2 + 1;

            if (left > size) {break;}

            int largerChild = left;

            if (right <= size && comp.compare(arr[right], arr[left]) > 0) {
                largerChild = right;
            }

            if (comp.compare(last, arr[largerChild]) >= 0) {break;}

            arr[index] = arr[largerChild];
            index = largerChild;
        }

        arr[index] = last;
        return root;
    }
}
