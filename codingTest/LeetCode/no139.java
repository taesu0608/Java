package codingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        int[] dp = new int[s.length()+1];
        //substring() : [start,exd)
        int idx = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                System.out.println(s.substring(0, i));
                dp[i] = 1;
            }
            for (int j = 0; j < i; j++) {
                System.out.println("i:" + i + "j :" + s.substring(j, i));
                if(dp[j] > 0 && wordDict.contains(s.substring(j, i))) {
                    System.out.println(2);
                    dp[i] = 1;
                };
            }
        }
        if(dp[s.length()] == 0) System.out.println(false);
        System.out.println(true);
    }
}
