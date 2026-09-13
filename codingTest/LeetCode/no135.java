package codingTest.LeetCode;

import java.util.Arrays;

public class no135 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int[] result = new int[ratings.length];
        result[0] = 1;

        for (int i = 0; i < ratings.length - 1; i++) {
            if(ratings[i] > ratings[i+1]) result[i + 1] = 0;
            else if(ratings[i] < ratings[i+1]) result[i + 1] = result[i] + 1;
            else result[i + 1] = 0;

            if(result[i + 1] == 0) {
                result[i + 1] = 1;
                int j = i+1;
                while(j > 0&&ratings[j] < ratings[j-1] && result[j] == result[j-1]) {
                    result[j-1]++;
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        }
}
