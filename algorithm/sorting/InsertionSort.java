package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {
    // 삽입 정렬
    /*
    원소를 새로이 받으면서 알맞은 위치를 찾아가는 방식
    7
    9 8 7 6 5 4 3
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[loop];

        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1;i<loop;i++){
            int n = Integer.parseInt(st.nextToken());

            int j = i - 1;
            /*삽입정렬은 두 단계로 이루어진다.

            1. i는 새로 삽입할 원소를 선택한다.
            2. j는 정렬된 영역에서 삽입 위치를 찾는다.

            arr[j] > n 인 동안
            큰 값들을 오른쪽으로 이동시키고
            반복이 끝난 뒤 j+1 위치에 n을 삽입한다.

            j는 반복 과정에서 -1까지 내려갈 수 있는데,
            그 경우 j+1이 0이 되어 자연스럽게
            배열의 맨 앞 삽입도 처리된다.

            또한 이동 연산이 항상 arr[j+1]을 기준으로 이루어져
            인덱스 처리 흐름이 매우 일관적이다.*/
            while(j >= 0 && arr[j] > n){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j + 1] = n;
        }

        for(int i = 0; i < loop; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
