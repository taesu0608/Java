package codingTest.LeetCode;

public class no300 {
    static int[] dp;
    static int[] nums;
    public static void main(String[] args) {
        nums = new int[]{0,1,0,3,2,3};
        dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
