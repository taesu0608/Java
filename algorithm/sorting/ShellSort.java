package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] arr = new int[loop];
        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i;

        // 셸 정렬 수행
        shell_sort(arr, arr.length);

        // 정렬 결과 출력
        for(i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private static void shell_sort(int[] list, int n) {
        for (int gap = n/2; gap > 0; gap /= 2) {
            if(gap%2 == 0){gap+=1;}

            for(int i = gap; i < n; i++){
                int temp = list[i];
                int j = i;

                while (j >= gap && list[j - gap] > temp) {
                    list[j] = list[j - gap];
                    j -= gap;
                }

                list[j] = temp;
            }
        }
    }
}
