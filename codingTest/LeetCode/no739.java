package codingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class no739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = new int[temperatures.length];


        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);


        for (int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int cidx = st.pop();
                result[cidx] = i - cidx;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            result[st.pop()] = 0;
        }

        System.out.println(Arrays.toString(result));
    }
}
