package codingTest.LeetCode;

public class no123 {
    public static void main(String[] args) {
        int maxProfit;
        int[] prices = {3,2,6,5,0,3};
        if (prices.length < 2);

        int highest = prices[prices.length-1];
        int[] max = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], highest - prices[i]);
            highest = Math.max(highest,prices[i]);
        }

        int lowest = prices[0];
        int answer = 0;
        int a;
        for (int i = 1; i < prices.length; i++) {
            a = prices[i] - lowest;
            lowest = Math.min(lowest,prices[i]);

            a = a + max[i+1];
            int secondProfit = (i + 1 < prices.length) ? max[i + 1] : 0;
            answer = Math.max(answer, a + secondProfit);
        }


        System.out.println(answer);
    }
}
