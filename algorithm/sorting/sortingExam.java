package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sortingExam {
    public static void main(String[] args) throws IOException {
        //선택 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int least = 0;
        int loop = Integer.parseInt(br.readLine());
        int[] arr = new int[loop];
        for(int i = 0; i < loop; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < loop - 1; i++){
            least = i;
            for(int j = i + 1; j < loop; j++){
                if(arr[j] < arr[least]){
                    least = j;
                }
            }
            if (least != i) {
                int t = arr[i];
                arr[i] = arr[least];
                arr[least] = t;
            }
        }

        for(int i = 0; i < loop; i++){
            System.out.println(arr[i]);
        }
    }

    public static void bubble() throws IOException {
        //버블 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] arr = new int[loop];
        for(int i = 0; i < loop; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int t;
        for (int i = loop - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if (arr[j] > arr[j+1])
                {
                    t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                }
            }
        }

        for(int i = 0; i < loop; i++){
            System.out.println(arr[i]);
        }
    }
}
