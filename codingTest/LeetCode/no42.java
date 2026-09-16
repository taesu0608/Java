package codingTest.LeetCode;

public class no42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(find(height));
    }
    static int find(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int sum = 0;

        while (left <= right) {
            if (maxL <= maxR) {
                maxL = Math.max(maxL, height[left]);
                sum += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                sum += maxR - height[right];
                right--;
            }
        }

        return sum;
    }
}
