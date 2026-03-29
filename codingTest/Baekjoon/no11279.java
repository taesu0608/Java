package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.compare;

/*
문제
널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

배열에 자연수 x를 넣는다.
배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는
정수 x가 주어진다. 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 자연수는 231보다 작다.

출력
입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고
한 경우에는 0을 출력하면 된다.

예제 입력 1
13
0
1
2
0
0
3
2
1
0
0
0
0
0
예제 출력 1
0
2
1
3
2
1
0
0
*/
public class no11279 {
    static int[] arr;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        size = 0;
        arr = new int[loop + 1];
        arr[0] = 0;
        int input;
        for (int i = 1; i <= loop; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (size == 0){sb.append(0).append("\n");}
                else sb.append(remove()).append("\n");
                continue;
            }
            add(input);
        }
        System.out.println(sb);
    }
    public static void add(int input) {
        size++;
        int index = size;
        while(index > 0){
            int parent = index/2;
            if(parent <= 0) break;
            if(arr[parent] >= input){ break;}
            arr[index] = arr[parent];
            index = parent;
        }

        arr[index] = input;
    }
    public static int remove(){
        if(size == 0) return 0;
        int last = arr[size];
        int root = arr[1];
        int index = 1;
        arr[size] = 0;
        size--;
        while(index < size) {
            int left = index*2;
            int right = index*2+1;
            int largerleaf = left;
            if(left > size) {break;}

            if(right <= size && compare((Integer) arr[right], (Integer) arr[left]) > 0){
                largerleaf = right;
            }
            if(compare(last, arr[largerleaf]) >= 0) break;
            arr[index] = arr[largerleaf];
            index = largerleaf;
        }

        arr[index] = last;
        return root;
    }
}
