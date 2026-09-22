package codingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class no76 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "b";

        int left = 0;
        int right = 0;
        int missing = 0; // 1은 미충족, 0은 충족
        int[] required = new int[128];
        // missing 설정, t 문자 기록
        for (int i = 0; i < t.length(); i++) {
            char c  = t.charAt(i);
            if(required[c] == 0) missing++;
            required[c]++;
        }
        int result_idx = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        while(right < s.length()) {
            right++;

            // 새롭게 추가된 right - 1 탐색, case 있다면
            char c = s.charAt(right - 1);
            if(t.indexOf(c) != -1){
                required[c]--;
                if(required[c] == 0) missing--;
            }

            //left가 t의 문자가 아닐경우 연속적으로 미루기
            while(left <= right - 1){
                if (t.indexOf(s.charAt(left)) == -1)
                    left++;
                else if (required[s.charAt(left)] < 0) {
                    required[s.charAt(left)]++;
                    left++;
                } else {
                    break;
                }
            }

            //missing 만족
            if(missing == 0) {
                // 결과값 갱신
                if (gap > (right - left)){
                    result_idx = left;
                    gap = right - left;
                }

                //left 이동
                required[s.charAt(left)]++;
                if(required[s.charAt(left)] > 0) missing++;
                left++;
            };

        }
        if (result_idx == Integer.MAX_VALUE) {
            System.out.println("");
        } else {
            System.out.println(s.substring(result_idx, result_idx + gap));
        }
    }
}
