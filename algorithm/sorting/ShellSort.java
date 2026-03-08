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

        // gap이 2일경우 gap 무한 증식 주의
        int gap = loop / 2 + 1;
        while(gap > 1){
            int idx = 0;
            for(int i = 0; i < gap; i++){
                while(idx < loop){
                    idx += gap;
                }
            }
        }
    }
}
