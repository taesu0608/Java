package codingTest.LeetCode;

public class no62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j+1<n)dp[i][j + 1] = dp[i][j+1] + dp[i][j];
                if(i+1<m)dp[i + 1][j] = dp[i+1][j] + dp[i][j];
            }
        }

        System.out.println(dp[m - 1][n - 1]);
    }
}
