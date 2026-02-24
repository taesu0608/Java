package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
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
}
