package codingTest.LeetCode;

public class no198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            for(int j = 0; j < i - 1; j++){
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            result = Math.max(result, dp[i]);
        }
    }
}
