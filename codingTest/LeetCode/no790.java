package codingTest.LeetCode;

public class no790 {
    public static void main(String[] args) {
        final long MOD = 1_000_000_007L;
        int n = 30;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(n <= 2) {
            //return n;
        }
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        System.out.println(dp[n]);
    }
}
