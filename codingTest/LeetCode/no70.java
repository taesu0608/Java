package codingTest.LeetCode;

public class no70 {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(n == 1) ;//{return 1;}
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
